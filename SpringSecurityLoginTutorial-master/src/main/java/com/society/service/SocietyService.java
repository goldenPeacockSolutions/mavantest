package com.society.service;

import java.util.List;

import com.society.model.Society;

public interface SocietyService {
	public void saveSociety(Society society);

	public Society findSocietyByName(String name);

	public List<Society> listAllSocieties();
}
