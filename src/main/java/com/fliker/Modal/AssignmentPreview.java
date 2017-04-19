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
import java.util.concurrent.TimeUnit;

import com.fliker.Repository.Assignment;
import com.fliker.Repository.Guidance;
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
			basicdbobj.put("assignmentADoc", assignment.getAssignmentADoc());
			basicdbobj.put("assignmentQDoc", assignment.getAssignmentQDoc());
			basicdbobj.put("assignmentstartdatetime", assignment.getAssignmentstartdatetime());
			basicdbobj.put("assignmentenddatetime", assignment.getAssignmentenddatetime());
			basicdbobj.put("averageVelocity", assignment.getAverageVelocity());
			basicdbobj.put("percentagescore", assignment.getPercentagescore());
			basicdbobj.put("noOfQuestions", assignment.getNoOfQuestions());
			
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
	
	
	
}
