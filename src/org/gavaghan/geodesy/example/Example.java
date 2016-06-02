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
<<<<<<< HEAD
		GlobalCoordinates eiffelTower;
		
		double xpos = 48.85889;
		double ypos = 2.29583;
		
		eiffelTower = new GlobalCoordinates(xpos, ypos);
=======
		GlobalCoordinates eiffelTower; 
		eiffelTower = new GlobalCoordinates(48.85889, 2.29583);
>>>>>>> 48f0f73a1e68f9c6e5cc2e44ced199fafca9660a

		double x=5000;
		double y = 0;
		double deg = Math.atan2(x, y)*180.0/Math.PI;
		System.out.println(deg);
		
		x=0;y=5000;
		deg = Math.atan2(x, y)*180.0/Math.PI;
		System.out.println(deg);
		
		x=-5000;y=0;
		deg = Math.atan2(x, y)*180.0/Math.PI;
		System.out.println(deg);	
		
		x=0;y=-5000;
		deg = Math.atan2(x, y)*180.0/Math.PI;
		System.out.println(deg);
		
		x=3267;y=-4834;
		double angle = Math.atan2(x, y)*180.0/Math.PI;	
		double dist=Math.sqrt(x*x+y*y);
		
		// calculate the geodetic curve
		GlobalCoordinates projected = geoCalc.calculateEndingGlobalCoordinates(reference, eiffelTower, angle, dist);
	    System.out.printf("   Destination: %1.4f%s", projected.getLatitude(), (projected.getLatitude() > 0) ? "N" : "S" );
	    System.out.printf(", %1.4f%s\n", projected.getLongitude(), (projected.getLongitude() > 0) ? "E" : "W");	
	}

	static public void main(String[] args)
	{
	    Example t = new Example();
	    t.calculation();
	}
}
