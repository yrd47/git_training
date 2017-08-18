package me.ele.arch.jenkins.client;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.*;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
        try{
            JenkinsServer jenkins = new JenkinsServer(new URI("http://192.168.96.22:8080/jenkins"), "admin", "adminadmin");
            System.out.println(jenkins.isRunning());
            System.out.println(jenkins.getVersion());
            Map<String, Job> jobs = jenkins.getJobs();
            System.out.println(jobs.keySet());
            Map<String, Job> jobView = jenkins.getJobs("gzs");
            System.out.println(jobView.keySet());
            Map<String, View> viewMap = jenkins.getViews();
            System.out.println(viewMap.keySet());
            View view = jenkins.getView("gzs");
            System.out.println("view name: " + view.getName() + "; view description: " + view.getDescription() +
                    "; view url: " + view.getUrl());
            JobWithDetails jobWithDetails = jenkins.getJob("DAL_Test");
            System.out.println(jobWithDetails.getDisplayName());
            MavenJobWithDetails mavenJobWithDetails = jenkins.getMavenJob("das_athena_core");
            System.out.println(mavenJobWithDetails.getDisplayName());
            System.out.println("---------------");
            build();
        }catch(Exception e){
            e.printStackTrace();
        }
	}

	public void create_job(){

    }

	public static void build(){
        String job_das = "das_athena_core";
//		String job_gzs = "gzs";
        String job_dalTest = "DAL_Test";
        String branchName = "release";
        int jobId = 0;
        boolean isBuildFinish = false;
        JenkinsClient jenkinsClient = new JenkinsClient();

        JobWithDetails jobWithDetails = jenkinsClient.getJob(job_das);
        jobId = jenkinsClient.buildJob(jobWithDetails,branchName);
        try{
            Thread.sleep(10000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        jobWithDetails = jenkinsClient.getJob(job_das);
        System.out.println(jobId);
        isBuildFinish = jenkinsClient.isJobFinish(jobWithDetails,jobId);
        System.out.println(isBuildFinish);
        try{
            Thread.sleep(30000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        isBuildFinish = jenkinsClient.isJobFinish(jobWithDetails,jobId);
        System.out.println(isBuildFinish);
        try{
            Thread.sleep(30000L);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            JobWithDetails jobWithDetails1 = jenkinsClient.getJob(job_dalTest);
            Build build = jobWithDetails1.getLastBuild();
            System.out.println(build.details().getId());
            System.out.println(build.details().getConsoleOutputText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test end");
    }
}