package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.entities.*;
import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.enums.Corps;
import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static Map<Integer, Soldier> soldierByIds = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("End")){
            Soldier soldier = createSoldier(input);
            if(soldier != null) {
                soldierByIds.put(soldier.getId(), soldier);
            }
            input = sc.nextLine();

        }
        for (Soldier soldier : soldierByIds.values()) {
            System.out.println(soldier.toString());
        }
    }

    private static Soldier createSoldier(String input) {
        String[] tokens = input.split("\\s+");
        String type = tokens[0];
        Soldier aPrivate;
        switch (type){
            case "Private":
                aPrivate = new PrivateImpl(Integer.parseInt(tokens[1]),
                                            tokens[2],
                                            tokens[3],
                                            Double.parseDouble(tokens[4]));
                break;
            case "LieutenantGeneral":
                aPrivate = createLieutenantGeneral(tokens);
                break;
            case "Engineer":
                aPrivate = createEngineer(tokens);
                break;
            case "Commando":
                aPrivate = createCommando(tokens);
                break;
            case "Spy":
                aPrivate = new SpyImpl(Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3],
                        tokens[4]);
                break;
            default:
                aPrivate = null;
        }
        return aPrivate;
    }

    private static Soldier createCommando(String[] tokens) {
        if(tokens[5].equals("Airforces") || tokens[5].equals("Marines" )) {
            Commando commando =  new CommandoImpl(Integer.parseInt(tokens[1]),
                    tokens[2],
                    tokens[3],
                    Double.parseDouble(tokens[4]),
                    Corps.valueOf(tokens[5].toUpperCase())
            );
            for (int i = 6; i < tokens.length; i += 2) {
                String codeName = tokens[i];
                String state = tokens[i+1];
                if(!state.equals("inProgress") && !state.equals("finished")){
                    continue;
                }

                Mission mission = new MissionImpl(codeName,
                        state.equals("inProgress") ? MissionImpl.Status.INPROGRESS :
                                MissionImpl.Status.FINISHED);
                commando.addMission(mission);
            }
            return commando;
        }
        return null;

    }

    private static Soldier createEngineer(String[] tokens) {
        if(tokens[5].equals("Airforces") || tokens[5].equals("Marines" )) {
            Engineer engineer =  new EngineerImpl(Integer.parseInt(tokens[1]),
                    tokens[2],
                    tokens[3],
                    Double.parseDouble(tokens[4]),
                    Corps.valueOf(tokens[5].toUpperCase())
                    );
            for (int i = 6; i < tokens.length; i += 2) {
                String partName = tokens[i];
                int hoursWorked = Integer.parseInt(tokens[i+1]);
                Repair repair = new RepairImpl(partName, hoursWorked);
                engineer.addRepair(repair);
            }
            return engineer;
        }
        return null;
    }

    private static Soldier createLieutenantGeneral(String[] tokens) {
        LieutenantGeneral soldier =  new LieutenantGeneralImpl(Integer.parseInt(tokens[1]),
                            tokens[2],
                            tokens[3],
                            Double.parseDouble(tokens[4]));
        for (int i = 5; i < tokens.length; i++) {
            soldier.addPrivate((Private) soldierByIds.get(Integer.parseInt(tokens[i])));
        }
        return soldier;
    }
}
