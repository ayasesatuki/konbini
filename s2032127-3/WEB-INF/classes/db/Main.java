package db;

import java.util.List;

public class Main {
	void allPokemon() {
		 PokemonDAO pokemonDAO = new PokemonDAO();
		 List<Pokemon> list = pokemonDAO.findAll();
		for (Pokemon p :list) {
			int id = p.getId();
			String name = p.getName();
			int attack = p.getAttack();
			int defence = p.getDefense();
			int stamina = p.getStamina();
			int cp = p.getCp();
			System.out.printf("%3d %-10s %3d %3d %3d %4d\n",id,name,attack,defence,stamina,cp);

		}
		}
	void pikachu() {
		 PokemonDAO pokemonDAO = new PokemonDAO();
		 List<Pokemon> list = pokemonDAO.pikachu();
		for (Pokemon p :list) {
			//int id = p.getId();
			//String name = p.getName();
			int attack = p.getAttack();
			int defence = p.getDefense();
			int stamina = p.getStamina();
			//int cp = p.getCp();
			System.out.printf("%3d %3d %3d \n",attack,defence,stamina);

		}
	}
	
	void threeLetters() {
		 PokemonDAO pokemonDAO = new PokemonDAO();
		 List<Pokemon> list = pokemonDAO.threeLetters();
		 //System.out.println(list.get(0));
		for (Pokemon p :list) {
			//int id = p.getId();
			String name = p.getName();
			//int attack = p.getAttack();
			//int defence = p.getDefense();
			//int stamina = p.getStamina();
			//int cp = p.getCp();
			System.out.printf("%-10s\n",name);

		}
	}
	
	void max() {
		PokemonDAO pokemonDAO = new PokemonDAO();
		List<Pokemon> list = pokemonDAO.max();
		Pokemon p = list.get(0);
		int maxattack = p.getMaxattack();
		
		int maxdefence = p.getMaxdefence() ;
		int maxstamina = p.getMaxstamina() ;
		System.out.printf("%3d %3d %3d\n",maxattack,maxdefence,maxstamina);
		}
	void denki() {
		 PokemonDAO pokemonDAO = new PokemonDAO();
		 List<Pokemon> list = pokemonDAO.denki();
		for (Pokemon p :list) {
			int id = p.getId();
			String name = p.getName();
			int attack = p.getAttack();
			int defence = p.getDefense();
			int stamina = p.getStamina();
			int cp = p.getCp();
			String type = p.getType();
			System.out.printf("%3d %-10s %3d %3d %3d %4d %-4s\n",id,name,attack,defence,stamina,cp,type);

		}
		}
	public static void  main(String atgs[]) {
		Main main = new Main();
		main.allPokemon();
		main.pikachu();
		main.threeLetters();
		main.max();
		main.denki();
	}

}
