package com.ispan.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ispan.demo.dto.MessageDto;
import com.ispan.demo.model.WorkMessages;
import com.ispan.demo.service.WorkMessagesService;

@Controller
public class MessagesController {
	
	@Autowired
	private WorkMessagesService wService;
	
	@GetMapping("/messages/add")
	public String addMessage(Model model) {
		
		WorkMessages w1 = new WorkMessages();
		model.addAttribute("workMessages", w1);
		
		WorkMessages latestMsg = wService.findLatest();
		
		model.addAttribute("latestMsg", latestMsg);
		
		return "messages/addMessages";
	}
	
	@PostMapping("/messages/add")
	public String postMessages(@ModelAttribute(name="workMessages") WorkMessages msg, Model model) {
		wService.insert(msg);
		
        WorkMessages w1 = new WorkMessages();
		model.addAttribute("workMessages", w1);
		
        WorkMessages latestMsg = wService.findLatest();
		model.addAttribute("latestMsg", latestMsg);
		
		return "messages/addMessages";
	}
	
	@GetMapping("/messages/page")
	public String viewMessages(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<WorkMessages> page = wService.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "messages/viewMessages";
	}
	
	@GetMapping("/messages/editMessage")
	public String editMessage(@RequestParam("id") Integer id, Model model) {
		WorkMessages msg = wService.findById(id);
		model.addAttribute("workMessage", msg);
		return "messages/editMessage";
	}
	
	@PostMapping("/messages/postEditMessage")
	public String postEditMessage(@ModelAttribute("workMessage") WorkMessages msg) {
		wService.insert(msg);
		return "redirect:/messages/page";
	}
	
	@GetMapping("/messages/delete")
	public String deleteMessage(@RequestParam("id") Integer id) {
		wService.deleteById(id);
		
		return "redirect:/messages/page";
	}
	
	@ResponseBody
	@PostMapping("/api/postMessage")
	public List<WorkMessages> postMessageApi(@RequestBody MessageDto dto){
		String text = dto.getMsg();
		WorkMessages newMsg = new WorkMessages();
		newMsg.setText(text);
		wService.insert(newMsg);
		
		Page<WorkMessages> page = wService.findByPage(1);
		List<WorkMessages> list = page.getContent();
		
		return list;
	}
	
	@GetMapping("/messages/ajax")
	public String ajaxPage() {
		return "messages/ajax-message";
	}
	

}
