package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
//		switch (unitType){
//			case "Archer":
//				return new Archer();
//			case "Pikeman":
//				return new Pikeman();
//			case "Swordsman":
//				return new Swordsman();
//			case "Horseman":
//				return new Horseman();
//			case "Gunner":
//				return new Gunner();
//			default:
//				return null;
//		}
		Class unitClass = null;
		try {
			unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
