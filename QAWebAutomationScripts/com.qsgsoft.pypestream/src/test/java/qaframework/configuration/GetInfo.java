package qaframework.configuration;

public class GetInfo {

	@SuppressWarnings({ "rawtypes", "restriction", "deprecation" })
	public static final String getCallingClassName(int parentLevel) {
		// Class CN = sun.reflect.Reflection.getCallerClass(parentLevel);
		Class CN = sun.reflect.Reflection.getCallerClass(parentLevel);
		String className = CN.toString();
		int pageIndex = className.indexOf("page");
		className = className.substring(pageIndex + 5);
		return className;
	}

	public static final String getCallingFunctionName(int parentLevel) {
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		StackTraceElement e = stacktrace[parentLevel];
		String methodName = e.getMethodName();
		return methodName;
	}

}
