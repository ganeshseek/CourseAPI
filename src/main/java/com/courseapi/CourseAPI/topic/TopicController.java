package com.courseapi.CourseAPI.topic;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping(value="/topics", produces = {"application/json"})
	public List<Topic> getAllTopic(){
		return topicService.getTopics();
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/topics/{id}",produces = {"application/xml"})
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addtopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
