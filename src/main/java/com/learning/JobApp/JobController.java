package com.learning.JobApp;

import com.learning.JobApp.model.JobPost;
import com.learning.JobApp.service.JobService;
import org.eclipse.jdt.internal.compiler.env.IModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService service;
    @GetMapping({"/","home"})
    public String home()
    {
        return "home";
    }
    @GetMapping(" ")
    public String addJob(){
        return "addjob";
    }
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }
    @GetMapping("viewalljobs")
    public String viewJobs(Model m){
        List<JobPost>jobs= service.getAllJobs();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
