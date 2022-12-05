package fr.m2i.slackonslacertif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.slackonslacertif.models.Channel;
import fr.m2i.slackonslacertif.services.ChannelService;

@RestController
@RequestMapping(path="/channel")
public class ControllerChannel{
	
	@Autowired
	ChannelService cs;

	private final String URL = "/channel";
	
	
	@RequestMapping (path = "/canalgeneral", method = RequestMethod.GET)
	public String getChannels(Model model, @ModelAttribute Channel channel) {
		model.addAttribute("channels", cs.getAll());
		return URL + "/canalgeneral";
	}
	
	@GetMapping (path = "/ajoutchannel")
	public String getFormulaireAjout() {
		return URL + "/ajoutchannel";
	}
	
	@PostMapping (path = "/ajoutchannel")
	public String postFormulaireAjout(Model model, @ModelAttribute Channel channel) {
		cs.saveChannel(channel);
		model.addAttribute("channels",cs.getAll());
		return "redirect:" + URL + "/canalgeneral";
	}
	
	@GetMapping (path = "/suppressionchannel")
	public String getFormulaireSupp() {
		return URL + "/supressionchannel";
	}
	
	@PostMapping (path = "/supressionchannel")
	public String postFormulaireSupp(Model model, @ModelAttribute Channel channel) {
		cs.deleteChannel(channel);
		model.addAttribute("channels",cs.getAll());
		return "redirect:" + URL + "/canalgeneral";
	}
	
		
	
}
