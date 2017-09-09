package com.example.weather.controller;

import com.example.weather.service.WeatherDataService;
import com.example.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 天气控制器.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherDataService weatherDataService;
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("weatherResponse",weatherDataService.getDataByCityId(cityId));
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/cityName/{cityName}")
	public ModelAndView getReportByCityName(@PathVariable("cityName") String cityName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("weatherResponse",weatherDataService.getDataByCityName(cityName));
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("/city/{cityName}")
	public WeatherResponse getReportByCity(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}

}
