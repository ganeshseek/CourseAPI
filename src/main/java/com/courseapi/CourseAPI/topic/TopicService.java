package com.courseapi.CourseAPI.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {


	List<Topic> list = new ArrayList<Topic> (Arrays.asList(
			new Topic("Spring","Spring framework","Spring framework descriptions"),
			new Topic("java","java framework","java framework descriptions"),
			new Topic(".net",".net framework",".net framework descriptions")));
	
	public List<Topic> getTopics() {
		return list;
		
	}
	
	public Topic getTopic(String id) {
		return list.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
	}

	public void addTopic(Topic topic) {
		list.add(topic);		
	}
	
	public void updateTopic(Topic topic, String id) {
		for (int i=0 ; i<= list.size(); i++) {
			Topic topicobj = list.get(i);
			if (topicobj.getId().equals(id)) {
				list.set(i, topic);
				return;
			}
			
			
		}
	}

	public void deleteTopic(String id) {
		list.removeIf(t->t.getId().equals(id));
		
	}
}
