package edu.vanderbilt.spring;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VideoService {

	private VideoRepository videos_;
	
	
	@Autowired
	public VideoService(VideoRepository repo) {
		videos_ = repo;
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.GET)
	public Video getVideo(@PathVariable("id") Long videoId){
		System.out.println("id:"+videoId);
		return videos_.findOne(videoId);
	}
	
	@RequestMapping(value="/video", method=RequestMethod.POST)
	public Iterable<Video> addVideo(@RequestBody Video video){
		videos_.save(video);
		return videos_.findAll();
	}
	
	@RequestMapping(value="/test/foo", method=RequestMethod.GET)
	public String myTest() {
			return "Test";
					
	}
	
	@RequestMapping(value="/video", method=RequestMethod.GET)
	public ArrayList<Video> listOfVideos() {
		ArrayList<Video> listOfVideos = new ArrayList<Video>();
		Iterable<Video> it = videos_.findAll();
		Iterator<Video> iter = it.iterator();
		while (iter.hasNext()) {
			listOfVideos.add(iter.next());
		}
		return listOfVideos;
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.POST)
	public void setMetadata(@RequestBody Video video, @PathVariable("name") String name, @PathVariable("genre") String genre,
			@PathVariable("url") String url, @PathVariable("size") Long size) {
		video.setName(name);
		video.setSize(size);
		video.setUrl(url);
		video.setGenre(genre);
	}
	
	@RequestMapping(value="/video/{id}", method=RequestMethod.DELETE)
	public void deleteVid(@PathVariable("id") Long videoId){
		videos_.delete(videoId);
	}
}
