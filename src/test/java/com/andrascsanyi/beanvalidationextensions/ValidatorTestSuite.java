package com.andrascsanyi.beanvalidationextensions;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Validator tests")
@SelectPackages("com.andrascsanyi.encyclopediagalactica.common")
public class ValidatorTestSuite {
}
