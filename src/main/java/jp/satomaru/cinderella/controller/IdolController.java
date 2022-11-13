package jp.satomaru.cinderella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.satomaru.cinderella.entity.Idol;
import jp.satomaru.cinderella.repository.IdolRepository;

@Controller
@RequestMapping(path = "/idol")
public class IdolController {

	@Autowired private IdolRepository idolRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Idol> getAllIdols() {
		return idolRepository.findAll();
	}
}
