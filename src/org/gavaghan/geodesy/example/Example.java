/* Theo deN Exter
 * 
 */
package org.gavaghan.geodesy.example;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;

public class Example {
	/**
	 * Calculate projection in degrees and radar meters
	 * 
	 * using WGS84 reference ellipsoid
	 */
	public void calculation() {
		// instantiate the calculator
		GeodeticCalculator geoCalc = new GeodeticCalculator();

		// select a reference elllipsoid
		Ellipsoid reference = Ellipsoid.WGS84;

		// set virtual radar coordinates
		GlobalCoordinates virtualRadar;

		// Virtual radar position Scheldt Area
		double xpos = 51.41667;
		double ypos = 4.08333;

		//OL: 4º 05' 00", NB: 51º 25' 00"
		//N 51 25.000 E004 05.000
		//N 51.41667, E 004.08333
		//RD: 64301, 381648
		virtualRadar = new GlobalCoordinates(xpos, ypos);

		// Radar coordinate
		double x = 5000;
		double y = 0;
		// 9.7674 km distance
		
		// Conversion into meters (according to spec)
		double bit = 2000.0/1024.0;
		x=x*bit;
		y=y*bit;
		
		// Triangulate into angle and distance
		double angle = Math.atan2(x, y) * 180.0 / Math.PI;
		double dist = Math.sqrt(x * x + y * y);

		// And project the geodetic curve
		GlobalCoordinates projected = geoCalc.calculateEndingGlobalCoordinates(
				reference, virtualRadar, angle, dist);
		
		// Output
		System.out.printf("   Destination: %1.4f%s", projected.getLatitude(),
				(projected.getLatitude() > 0) ? "N" : "S");
		System.out.printf(", %1.4f%s\n", projected.getLongitude(),
				(projected.getLongitude() > 0) ? "E" : "W");
	}

	static public void main(String[] args) {
		Example t = new Example();
		t.calculation();
	}
}
