package com.PostDeleteSeparate.testSuite;

import org.testng.annotations.DataProvider;

public class PostDeleteDDSeparate {

	@DataProvider(name = "InputData")
	public Object[][] DataForInput() {

		return new Object[][] { { "gareth", "bell", 1 }, { "eden", "hazard", 2 } };

	}

	@DataProvider(name = "DeleteData")
	public Object[] DataForDelete() {

		return new Object[] { 4, 5, 6, 7 };

	}

}
