/**
 * 
 */
package in.sachin.cricket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sachingoyal
 *
 */
@Controller
public class TestController extends MasterController{
	
	@RequestMapping(value = "/home/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getTestResponse() {
		return "{\n" + 
				"  \"dateTimeGMT\": \"2021-04-02T21:30:00.000Z\",\n" + 
				"  \"data\": {\n" + 
				"    \"fielding\": [\n" + 
				"      {\n" + 
				"        \"title\": \"Fielding for Wellington 1st INNINGS Auckland Team\",\n" + 
				"        \"scores\": [\n" + 
				"          {\n" + 
				"            \"name\": \"Ben Horne\",\n" + 
				"            \"runout\": 0,\n" + 
				"            \"stumped\": 0,\n" + 
				"            \"bowled\": 0,\n" + 
				"            \"lbw\": 0,\n" + 
				"            \"catch\": 1,\n" + 
				"            \"pid\": \"559061\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Ross ter Braak\",\n" + 
				"            \"runout\": 0,\n" + 
				"            \"stumped\": 0,\n" + 
				"            \"bowled\": 1,\n" + 
				"            \"lbw\": 0,\n" + 
				"            \"catch\": 0,\n" + 
				"            \"pid\": \"959775\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Danru Ferns\",\n" + 
				"            \"runout\": 0,\n" + 
				"            \"stumped\": 0,\n" + 
				"            \"bowled\": 0,\n" + 
				"            \"lbw\": 1,\n" + 
				"            \"catch\": 0,\n" + 
				"            \"pid\": \"1080812\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"W O'Donnell\",\n" + 
				"            \"runout\": 0,\n" + 
				"            \"stumped\": 0,\n" + 
				"            \"bowled\": 0,\n" + 
				"            \"lbw\": 0,\n" + 
				"            \"catch\": 1,\n" + 
				"            \"pid\": \"1163453\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Ryan Harrison\",\n" + 
				"            \"runout\": 0,\n" + 
				"            \"stumped\": 0,\n" + 
				"            \"bowled\": 0,\n" + 
				"            \"lbw\": 0,\n" + 
				"            \"catch\": 2,\n" + 
				"            \"pid\": \"1214273\"\n" + 
				"          }\n" + 
				"        ]\n" + 
				"      }\n" + 
				"    ],\n" + 
				"    \"bowling\": [\n" + 
				"      {\n" + 
				"        \"scores\": [\n" + 
				"          {\n" + 
				"            \"NB\": \"1\",\n" + 
				"            \"WD\": \"2\",\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 12,\n" + 
				"            \"0s\": 82,\n" + 
				"            \"Econ\": \"4.32\",\n" + 
				"            \"W\": \"2\",\n" + 
				"            \"R\": \"82\",\n" + 
				"            \"M\": \"7\",\n" + 
				"            \"O\": \"19\",\n" + 
				"            \"bowler\": \"Danru Ferns\",\n" + 
				"            \"pid\": \"1080812\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"NB\": \"0\",\n" + 
				"            \"WD\": \"1\",\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 7,\n" + 
				"            \"0s\": 73,\n" + 
				"            \"Econ\": \"3.07\",\n" + 
				"            \"W\": \"3\",\n" + 
				"            \"R\": \"46\",\n" + 
				"            \"M\": \"1\",\n" + 
				"            \"O\": \"15\",\n" + 
				"            \"bowler\": \"Ross ter Braak\",\n" + 
				"            \"pid\": \"959775\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"NB\": \"0\",\n" + 
				"            \"WD\": \"0\",\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 4,\n" + 
				"            \"0s\": 40,\n" + 
				"            \"Econ\": \"3.33\",\n" + 
				"            \"W\": \"0\",\n" + 
				"            \"R\": \"30\",\n" + 
				"            \"M\": \"1\",\n" + 
				"            \"O\": \"9\",\n" + 
				"            \"bowler\": \"Ryan Harrison\",\n" + 
				"            \"pid\": \"1214273\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"NB\": \"0\",\n" + 
				"            \"WD\": \"0\",\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 0,\n" + 
				"            \"0s\": 32,\n" + 
				"            \"Econ\": \"0.83\",\n" + 
				"            \"W\": \"0\",\n" + 
				"            \"R\": \"5\",\n" + 
				"            \"M\": \"3\",\n" + 
				"            \"O\": \"6\",\n" + 
				"            \"bowler\": \"Robert O'Donnell\",\n" + 
				"            \"pid\": \"562263\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"NB\": \"0\",\n" + 
				"            \"WD\": \"0\",\n" + 
				"            \"6s\": 2,\n" + 
				"            \"4s\": 3,\n" + 
				"            \"0s\": 69,\n" + 
				"            \"Econ\": \"3.06\",\n" + 
				"            \"W\": \"0\",\n" + 
				"            \"R\": \"49\",\n" + 
				"            \"M\": \"2\",\n" + 
				"            \"O\": \"16\",\n" + 
				"            \"bowler\": \"Louis Delport\",\n" + 
				"            \"pid\": \"794311\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"NB\": \"0\",\n" + 
				"            \"WD\": \"0\",\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 5,\n" + 
				"            \"0s\": 124,\n" + 
				"            \"Econ\": \"1.64\",\n" + 
				"            \"W\": \"1\",\n" + 
				"            \"R\": \"41\",\n" + 
				"            \"M\": \"8\",\n" + 
				"            \"O\": \"25\",\n" + 
				"            \"bowler\": \"William Somerville\",\n" + 
				"            \"pid\": \"38607\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"NB\": \"1\",\n" + 
				"            \"WD\": \"0\",\n" + 
				"            \"6s\": 1,\n" + 
				"            \"4s\": 0,\n" + 
				"            \"0s\": 28,\n" + 
				"            \"Econ\": \"2.67\",\n" + 
				"            \"W\": \"0\",\n" + 
				"            \"R\": \"16\",\n" + 
				"            \"M\": \"0\",\n" + 
				"            \"O\": \"6\",\n" + 
				"            \"bowler\": \"Glenn Phillips\",\n" + 
				"            \"pid\": \"823509\"\n" + 
				"          }\n" + 
				"        ],\n" + 
				"        \"title\": \"Bowling To Wellington 1st INNINGS Auckland Team\"\n" + 
				"      }\n" + 
				"    ],\n" + 
				"    \"batting\": [\n" + 
				"      {\n" + 
				"        \"scores\": [\n" + 
				"          {\n" + 
				"            \"dismissal-by\": {\n" + 
				"              \"name\": \"Ross ter Braak\",\n" + 
				"              \"pid\": \"959775\"\n" + 
				"            },\n" + 
				"            \"dismissal\": \"bowled\",\n" + 
				"            \"SR\": 8,\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 0,\n" + 
				"            \"M\": 0,\n" + 
				"            \"B\": 24,\n" + 
				"            \"R\": 2,\n" + 
				"            \"dismissal-info\": \"b ter Braak\",\n" + 
				"            \"batsman\": \"Luke Georgeson\",\n" + 
				"            \"pid\": \"1129637\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"dismissal-by\": {\n" + 
				"              \"name\": \"Ben Horne\",\n" + 
				"              \"pid\": \"559061\"\n" + 
				"            },\n" + 
				"            \"dismissal\": \"catch\",\n" + 
				"            \"SR\": 80,\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 1,\n" + 
				"            \"M\": 0,\n" + 
				"            \"B\": 5,\n" + 
				"            \"R\": 4,\n" + 
				"            \"dismissal-info\": \"c  Horne b ter Braak\",\n" + 
				"            \"batsman\": \"Rachin Ravindra\",\n" + 
				"            \"pid\": \"959767\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"dismissal-by\": {\n" + 
				"              \"name\": \"Ryan Harrison\",\n" + 
				"              \"pid\": \"1214273\"\n" + 
				"            },\n" + 
				"            \"dismissal\": \"catch\",\n" + 
				"            \"SR\": 54,\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 1,\n" + 
				"            \"M\": 0,\n" + 
				"            \"B\": 11,\n" + 
				"            \"R\": 6,\n" + 
				"            \"dismissal-info\": \"c Harrison b ter Braak\",\n" + 
				"            \"batsman\": \"Jakob Bhula\",\n" + 
				"            \"pid\": \"1129632\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"dismissal-by\": {\n" + 
				"              \"name\": \"W O'Donnell\",\n" + 
				"              \"pid\": \"1163453\"\n" + 
				"            },\n" + 
				"            \"dismissal\": \"catch\",\n" + 
				"            \"SR\": 45,\n" + 
				"            \"6s\": 1,\n" + 
				"            \"4s\": 12,\n" + 
				"            \"M\": 0,\n" + 
				"            \"B\": 231,\n" + 
				"            \"R\": 105,\n" + 
				"            \"dismissal-info\": \"c RR O'Donnell b Ferns\",\n" + 
				"            \"batsman\": \"Michael Bracewell (c)\",\n" + 
				"            \"pid\": \"326968\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"dismissal-by\": {\n" + 
				"              \"name\": \"Danru Ferns\",\n" + 
				"              \"pid\": \"1080812\"\n" + 
				"            },\n" + 
				"            \"dismissal\": \"lbw\",\n" + 
				"            \"SR\": 50,\n" + 
				"            \"6s\": 2,\n" + 
				"            \"4s\": 12,\n" + 
				"            \"M\": 0,\n" + 
				"            \"B\": 226,\n" + 
				"            \"R\": 113,\n" + 
				"            \"dismissal-info\": \"lbw b Ferns\",\n" + 
				"            \"batsman\": \"Tom Blundell  \",\n" + 
				"            \"pid\": \"440516\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"dismissal\": \"not out\",\n" + 
				"            \"SR\": 13,\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 0,\n" + 
				"            \"M\": 0,\n" + 
				"            \"B\": 45,\n" + 
				"            \"R\": 6,\n" + 
				"            \"dismissal-info\": \"not out\",\n" + 
				"            \"batsman\": \"Troy Johnson\",\n" + 
				"            \"pid\": \"1169695\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"dismissal-by\": {\n" + 
				"              \"name\": \"Ryan Harrison\",\n" + 
				"              \"pid\": \"1214273\"\n" + 
				"            },\n" + 
				"            \"dismissal\": \"catch\",\n" + 
				"            \"SR\": 121,\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 5,\n" + 
				"            \"M\": 0,\n" + 
				"            \"B\": 19,\n" + 
				"            \"R\": 23,\n" + 
				"            \"dismissal-info\": \"c Harrison b Somerville\",\n" + 
				"            \"batsman\": \"Jamie Gibson\",\n" + 
				"            \"pid\": \"707173\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"dismissal\": \"not out\",\n" + 
				"            \"SR\": 5,\n" + 
				"            \"6s\": 0,\n" + 
				"            \"4s\": 0,\n" + 
				"            \"M\": 0,\n" + 
				"            \"B\": 17,\n" + 
				"            \"R\": 1,\n" + 
				"            \"dismissal-info\": \"not out\",\n" + 
				"            \"batsman\": \"Peter Younghusband\",\n" + 
				"            \"pid\": \"707183\"\n" + 
				"          }\n" + 
				"        ],\n" + 
				"        \"title\": \"Wellington 1st INNINGS Auckland Team\"\n" + 
				"      }\n" + 
				"    ],\n" + 
				"    \"team\": [\n" + 
				"      {\n" + 
				"        \"players\": [\n" + 
				"          {\n" + 
				"            \"name\": \"Sean Solia\",\n" + 
				"            \"pid\": \"707109\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"William O'Donnell\",\n" + 
				"            \"pid\": \"1163453\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Glenn Phillips\",\n" + 
				"            \"pid\": \"823509\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Robert O'Donnell\",\n" + 
				"            \"pid\": \"562263\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Ben Horne\",\n" + 
				"            \"pid\": \"559061\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Ross ter Braak\",\n" + 
				"            \"pid\": \"959775\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"William Somerville\",\n" + 
				"            \"pid\": \"38607\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Ryan Harrison\",\n" + 
				"            \"pid\": \"1214273\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Louis Delport\",\n" + 
				"            \"pid\": \"794311\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Danru Ferns\",\n" + 
				"            \"pid\": \"1080812\"\n" + 
				"          }\n" + 
				"        ],\n" + 
				"        \"name\": \"Auckland\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"        \"players\": [\n" + 
				"          {\n" + 
				"            \"name\": \"Luke Georgeson\",\n" + 
				"            \"pid\": \"1129637\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Rachin Ravindra\",\n" + 
				"            \"pid\": \"959767\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Jakob Bhula\",\n" + 
				"            \"pid\": \"1129632\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Michael Bracewell\",\n" + 
				"            \"pid\": \"326968\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Tom Blundell\",\n" + 
				"            \"pid\": \"440516\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Troy Johnson\",\n" + 
				"            \"pid\": \"1169695\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Jamie Gibson\",\n" + 
				"            \"pid\": \"707173\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Peter Younghusband\",\n" + 
				"            \"pid\": \"707183\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Logan van Beek\",\n" + 
				"            \"pid\": \"440522\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Ian McPeake\",\n" + 
				"            \"pid\": \"599385\"\n" + 
				"          },\n" + 
				"          {\n" + 
				"            \"name\": \"Ben Sears\",\n" + 
				"            \"pid\": \"959769\"\n" + 
				"          }\n" + 
				"        ],\n" + 
				"        \"name\": \"Wellington\"\n" + 
				"      }\n" + 
				"    ],\n" + 
				"    \"man-of-the-match\": \"\",\n" + 
				"    \"toss_winner_team\": \"Wellington\",\n" + 
				"    \"matchStarted\": true\n" + 
				"  },\n" + 
				"  \"cache3\": true,\n" + 
				"  \"creditsLeft\": 220,\n" + 
				"  \"v\": \"1\",\n" + 
				"  \"ttl\": 2,\n" + 
				"  \"provider\": {\n" + 
				"    \"source\": \"Various\",\n" + 
				"    \"url\": \"https://cricapi.com/\",\n" + 
				"    \"pubDate\": \"2021-04-03T11:09:51.584Z\"\n" + 
				"  }\n" + 
				"}";
	}

}
