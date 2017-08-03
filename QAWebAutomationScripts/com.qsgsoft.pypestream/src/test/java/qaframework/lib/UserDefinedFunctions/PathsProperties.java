package qaframework.lib.UserDefinedFunctions;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PathsProperties {

	/****************************************
	 * Function to read the excel path
	 *****************************************/
	public Properties Read_FilePath() throws Exception {
		Properties autoitProps = new Properties();
		URL url = getClass().getResource("/path.properties");
		InputStream is = url.openStream();
		autoitProps.load(is);
		return autoitProps;
	}
}
