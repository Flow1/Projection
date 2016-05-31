/* Theo deN Exter
 * 
 */
package org.gavaghan.geodesy.example;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;

public class Example
{
	/**
	 * Calculate projection in degrees and meters
	 *   
	 * using WGS84 reference ellipsoid
	 */
	public void calculation()
	{
		// instantiate the calculator
		GeodeticCalculator geoCalc = new GeodeticCalculator();

		// select a reference elllipsoid
		Ellipsoid reference = Ellipsoid.WGS84;

		// set Eiffel Tower coordinates
		GlobalCoordinates eiffelTower;
		eiffelTower = new GlobalCoordinates(48.85889, 2.29583);

		// calculate the geodetic curve
		GlobalCoordinates projected = geoCalc.calculateEndingGlobalCoordinates(reference, eiffelTower, 100, 1000);
	    System.out.printf("   Destination: %1.4f%s", projected.getLatitude(), (projected.getLatitude() > 0) ? "N" : "S" );
	    System.out.printf(", %1.4f%s\n", projected.getLongitude(), (projected.getLongitude() > 0) ? "E" : "W");	
	}

	static public void main(String[] args)
	{
	    Example t = new Example();
	    t.calculation();
	}
}
