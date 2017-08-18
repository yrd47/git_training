package me.ele.arch.jenkins.client;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class JenkinsClient {

	public JobWithDetails getJob(String jobName){
		JobWithDetails jobWithDetails = new JobWithDetails();
		try{
			JenkinsServer jenkins = new JenkinsServer(new URI("http://192.168.96.22:8080/jenkins"), "admin", "adminadmin");
			Map<String, Job> jobs = jenkins.getJobs();
			jobWithDetails = jobs.get(jobName).details();
		}catch(Exception e){
			e.printStackTrace();
		}
		return jobWithDetails;
	}
	
	public int buildJob(JobWithDetails jobWithDetails,String branchName) {
		int buildNumber = 0;
		try{
			buildNumber = jobWithDetails.getNextBuildNumber();
			Map<String, String> params = new HashMap<String, String>();
			params.put("branch_name", branchName);
			jobWithDetails.build(params,true);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return buildNumber;
	}
	
	public boolean isJobFinish(JobWithDetails jobWithDetails,int jobId){
		boolean isBuilding = false;
		try{
			Build build = jobWithDetails.getBuildByNumber(jobId);
			isBuilding = build.details().isBuilding();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return !isBuilding;
	}
}
