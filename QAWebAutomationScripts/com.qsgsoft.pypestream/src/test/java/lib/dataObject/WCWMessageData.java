package lib.dataObject;

import lib.dataObject.WCWData.WebTag;
import qaframework.lib.UserDefinedFunctions.ReadDataFromXMLfile;

public class WCWMessageData {
	public WCWMessageData() throws Exception {

	}

	ReadDataFromXMLfile xml = new ReadDataFromXMLfile();
	static final String FILEPATH = "WCWStreamDetailsxml";
	
	public final String slingBot = xml.read(WebTag.SLINGBOT, FILEPATH),
			            botMessage = xml.read(WebTag.BOTMESSAGE, FILEPATH),
			            botReply = xml.read(WebTag.BOTREPLY, FILEPATH),
			            agentEmail = xml.read(WebTag.AGENTEMAIL, FILEPATH),
			            slingBotAutoMsg = xml.read(WebTag.SLINGBOTAUTOMSG, FILEPATH),
			            message = xml.read(WebTag.MESSAGE, FILEPATH),
			            support = xml.read(WebTag.SUPPORT, FILEPATH);

	public static class WebTag {
		public static final String SLINGBOT = "Sling",
				                   BOTMESSAGE = "strBotMessage", 
				                   AGENTEMAIL = "strEmailAgent",
				                   BOTREPLY = "strBotReply",
				                   SLINGBOTAUTOMSG = "strSlingBotAutoMsg",
				                   MESSAGE = "Message",
				                   SUPPORT="Support";
	}


}
