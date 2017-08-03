package qaframework.configuration;

import org.testng.TestListenerAdapter;
import org.testng.IClass;
import org.testng.ITestResult;

public class ListenerClass extends TestListenerAdapter {

	@Override
	public void onTestStart(ITestResult tr) {

		log("Test Started....");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		log("Test '" + tr.getName() + "' PASSED");
		log(tr.getTestClass());
		log("Priority of this method is " + tr.getMethod().getPriority());
		System.out.println(".....");
	}

	@Override
	public void onTestFailure(ITestResult tr) {

		log("Test '" + tr.getName() + "' FAILED");
		log("Failed method  Description  " + tr.getMethod().getDescription());
		log("Failed in method name  " + tr.getMethod().getMethodName());
		log("Failed in method  " + tr.getMethod().getConstructorOrMethod());
		log("Failed in method  " + tr.getInstanceName());
		System.out.println(".....");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	}

	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}

}
