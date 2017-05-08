package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Assignment;
import com.fliker.Repository.Guidance;
import com.fliker.Repository.QuestionAnswerDocSet;
import com.mongodb.BasicDBObject;

public class AssignmentPreview {

	
	private ArrayList answerset;
	private ArrayList questionsets;
	
	
	public void createAssignment(String assignques){
		
		Assignment asignment = new Assignment();
		
		
	}

	public void submitAssignment(String assignstarttime, String assignenddate){
		
		Assignment asignment = new Assignment();
		AssignmentPreview assignprev = new AssignmentPreview();
		
		
		
		String uniqueid = "";
		
		try {
			uniqueid = assignprev.makeSHA1Hash(assignstarttime+assignenddate);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		asignment.setAssignmentid(uniqueid);
		asignment.setAssignmentstartdatetime(assignstarttime);
		
	}
	
	
	public String makeSHA1Hash(String input)
	          throws NoSuchAlgorithmException, UnsupportedEncodingException
	      {
	          MessageDigest md = MessageDigest.getInstance("SHA1");
	          md.reset();
	          byte[] buffer = input.getBytes("UTF-8");
	          md.update(buffer);
	          byte[] digest = md.digest();

	          String hexStr = "";
	          for (int i = 0; i < digest.length; i++) {
	              hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
	          }
	          return hexStr;
	      }

	  public BasicDBObject formDBObject(Assignment assignment){
			
			BasicDBObject basicdbobj = new BasicDBObject();
			basicdbobj.put("assignmentid", assignment.getAssignmentid());
			basicdbobj.put("assignmentanswersheet", assignment.getAssignmentanswersheet());
			basicdbobj.put("assignmentquestionsets", assignment.getAssignmentquestionsets());
			basicdbobj.put("assignmentstartdatetime", assignment.getAssignmentstartdatetime());
			basicdbobj.put("assignmentenddatetime", assignment.getAssignmentenddatetime());
			basicdbobj.put("averageVelocity", assignment.getAverageVelocity());
			basicdbobj.put("percentagescore", assignment.getPercentagescore());
			basicdbobj.put("noOfQuestions", assignment.getNoOfQuestions());
			
			return basicdbobj;
			
		}
	  
	  
	  public BasicDBObject formQuestionSetDBObject(QuestionAnswerDocSet questionsetdoc){
			
			BasicDBObject basicdbobj = new BasicDBObject();
			basicdbobj.put("fileid", questionsetdoc.getFileid());
			basicdbobj.put("sheetContent", questionsetdoc.getSheetContent());
			basicdbobj.put("sheetContentNo", questionsetdoc.getSheetContentNo());
			basicdbobj.put("sheetdocid", questionsetdoc.getSheetdocid());
			return basicdbobj;
			
		}

	public HashMap formElement(String[] questions, String[] questiondoc, String[] answers, String[] answerdoc) {
		// TODO Auto-generated method stub
		
		HashMap elementmap = new HashMap();
		
		AssignmentPreview assignprev = new AssignmentPreview();
		
		ArrayList questionlist = assignprev.forQuestionSet(questions, questiondoc);
		ArrayList answerlist = assignprev.forQuestionSet(answers, answerdoc);
		
		elementmap.put(assignprev.forQuestionSet(questions, questiondoc), assignprev.forAnswerSet(answers, answerdoc));
		
		for(int t=0;t<questionlist.size();t++){
			
			
			
		}
		
		
		return elementmap;
	}
	
	public ArrayList forQuestionSet(String[] questions, String[] questiondoc){
		
		ArrayList questionlist  = new ArrayList();
		
		for(int s=1;s==questions.length;s++){
			
			HashMap questionset = new HashMap();
			String questiondocs = "";
			
			for(int m=0;m<questiondoc.length;m++){
				String[] questionsdocele = questiondoc[m].split("--");
				if(questionsdocele[0] == Integer.toString(s)){
					questiondocs =  questionsdocele[1];
				}
				
			}
			
			questionset.put(questions[s], questiondocs);
			questionlist.add(questionset);
			
		}
		
		return questionlist;
		
	}
	
	
	public ArrayList forAnswerSet(String[] answers, String[] answerdoc){
		
		ArrayList answerlist  = new ArrayList();
		
		for(int s=1;s==answers.length;s++){
			
			String answersgiven = "";
			
			if(!answers[s].isEmpty()){
				answersgiven = answers[s];
			}
			
			HashMap answerset = new HashMap();
			String answerdocs = "";
			
			for(int m=0;m<answerdoc.length;m++){
				String[] questionsdocele = answerdoc[m].split("--");
				if(questionsdocele[0] == Integer.toString(s)){
					answerdocs =  questionsdocele[1];
				}
				
			}
			
			answerset.put(answers[s], answerdocs);
			answerlist.add(answerset);
			
		}
		
		return answerlist;
		
	}
	
	
	public String getAverageVelocity(String startdatetime, String enddatetime){
		
		String averagevelocity = "";
		AssignmentPreview assignprev = new AssignmentPreview();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		
		DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        try {

            Date datestart = formatter.parse(startdatetime);
            Date dateend = formatter.parse(enddatetime);
            String datediff = assignprev.getTimeDiff(datestart, dateend);
            
            Date date = new Date();
            String currentdate = sdf.format(date);
            
            String currentdiff = assignprev.getTimeDiff(date, dateend);
            
            int currintdiff = Integer.parseInt(currentdiff);
            
            if(currintdiff<0){
            	averagevelocity = "-1";
            }
            

        } catch (ParseException e) {
            e.printStackTrace();
        }

		
		return averagevelocity;
	}
	
	
	public String getTimeDiff(Date dateOne, Date dateTwo) {
        String diff = "";
        long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime()); 
        diff = String.format("%d hour(s) %d min(s)", TimeUnit.MILLISECONDS.toHours(timeDiff), TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));
        return diff;
        
	}

	public void saveAssignmentQuestionSet(HashMap<Integer, HashMap<String, String>> assignquestionset) {
		// TODO Auto-generated method stub
		
		QuestionAnswerDocSet quesansdoc = new QuestionAnswerDocSet();
		AssignmentPreview assignprev = new AssignmentPreview();
		StringBuffer sheetdocid = new StringBuffer();
		
		Set assignqnset = assignquestionset.entrySet();
		Iterator assigniter = assignqnset.iterator();
		while(assigniter.hasNext()){
			
			Map.Entry meassign = (Map.Entry)assigniter.next();
			
			String assignmentQnNo = (String)meassign.getKey();
			String assignmentQn = "";
			String assignmentFileids = "";
			String[] assignfilarr = null;
			
			HashMap entryassign = (HashMap)meassign.getValue();
			Set entryassignset = entryassign.entrySet();
			Iterator entryassigniter = entryassignset.iterator();
			while(entryassigniter.hasNext()){
				Map.Entry mentryassign = (Map.Entry)entryassigniter.next();
				
				assignmentQn = (String)mentryassign.getKey();
				assignmentFileids = (String)mentryassign.getValue();
				assignfilarr = assignmentFileids.split(",");
				
			}
			
			String uniqueid = "";
			
			try {
				uniqueid = assignprev.makeSHA1Hash(assignmentQn);
				sheetdocid.append(uniqueid);
				sheetdocid.append(",");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			quesansdoc.setSheetdocid(uniqueid);
			quesansdoc.setSheetContent(assignmentQn);
			quesansdoc.setSheetContentNo(assignmentQnNo);
			quesansdoc.setFileid(assignfilarr);
			
			MongoConnection mongocon = new MongoConnection();
			BasicDBObject basicreqobj =  assignprev.formQuestionSetDBObject(quesansdoc);
			mongocon.saveObject(basicreqobj, "QuestionAnswerDocSet");
			
			String[] newsheetdocids = (sheetdocid.substring(0,sheetdocid.length()-1)).split(",");
			
			Assignment assignment = new Assignment();
			
			String uniqueidassign = "";
			
			try {
				uniqueidassign = assignprev.makeSHA1Hash(assignmentQn);
				sheetdocid.append(uniqueidassign);
				sheetdocid.append(",");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			assignment.setAssignmentid(uniqueidassign);
			assignment.setNoOfQuestions(Integer.toString(assignquestionset.size()));
			assignment.setAssignmentquestionsets(newsheetdocids);
			
			MongoConnection mongocondb = new MongoConnection();
			BasicDBObject basicreqobjassign =  assignprev.formDBObject(assignment);
			mongocondb.saveObject(basicreqobjassign, "Assignment");
			
			
		}
		
		
		
		
	}

	
	
	
	
}
