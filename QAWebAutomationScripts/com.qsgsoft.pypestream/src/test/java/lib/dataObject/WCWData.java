package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.ReadDataFromXMLfile;

public class WCWData {

	public WCWData() throws Exception {

	}

	ReadDataFromXMLfile xml = new ReadDataFromXMLfile();
	static final String FILEPATH = "WCWLoginDetailsxml";
	public final String salesEmail = xml.read(WebTag.SALESEMAIL, FILEPATH),
			pypemanager = xml.read(WebTag.PYPEMANAGERLOGIN, FILEPATH),
		    pypemanagerpwd = xml.read(WebTag.PYPEMANAGERPASS, FILEPATH),
		    agentEmail = xml.read(WebTag.AGENTEMAIL, FILEPATH),
		    singleStreamManager = xml.read(WebTag.SINGLESTREAMMANAGER, FILEPATH),
		    strAdminLogin = xml.read(WebTag.STRADMINLOGIN, FILEPATH),
		    strAdminPass = xml.read(WebTag.STRADMINPASS, FILEPATH),
		    singleSessionManager = xml.read(WebTag.SINGLESESSIONMANAGER, FILEPATH),
		    singleSessionAgnet = xml.read(WebTag.SINGLESESSIONAGENT, FILEPATH),
		    agentEmail1 = xml.read(WebTag.AGENTEMAIL1, FILEPATH);

	public static class WebTag {
		public static final String SALESEMAIL = "strSalesForceEmail",
				PYPEMANAGERLOGIN = "WCWPypemanagerLogin",
				PYPEMANAGERPASS = "WCWPypemanagerPassword",
				AGENTEMAIL = "AgentEmail",
			    SINGLESTREAMMANAGER = "PypemanagerSingleStream",
			    STRADMINLOGIN = "StrAdminLogin",
			    STRADMINPASS = "StrAdminPass",
			    SINGLESESSIONMANAGER = "SingleSessionManager",
			    SINGLESESSIONAGENT = "SingleSessionAgent",
			    AGENTEMAIL1 = "AgentEmail1";
	}

}
