package edu.ycp.cs320.jporter7.populationdb;
/*
 * Copied from class lab
 */
import java.util.Scanner;

import edu.ycp.cs320.jporter7.populationdb.persist.DatabaseProvider;
import edu.ycp.cs320.jporter7.populationdb.persist.FakeDatabase;
import edu.ycp.cs320.jporter7.populationdb.persist.DerbyDatabase;

public class InitDatabase {
	public static void init() {
		DatabaseProvider.setInstance(new DerbyDatabase());
	}
}
