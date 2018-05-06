package com;

import java.util.ArrayList;
import java.util.List;

//Classe permettant de g�n�rer l'arbre contenant tous les plateaux possibles.
public class Noeud {
	public static final int UNDEFINED=9999999;//Valeur permettant de savoir si la valeur d'un noeud a �t� trouv�e ou non.
	protected Noeud pere;//Noeud pere
	protected List<Noeud> fils;//Liste des noeuds fils
	protected Plateau plateau; //Copie du plateau contenant un coup qui a �t� jou�.
	protected int valeur_noeud;
	
	public Noeud(Plateau p)
	{
		pere = null;
		fils = new ArrayList<Noeud>();
		plateau = new Plateau(p);
		valeur_noeud = UNDEFINED;
	}
	
	public Noeud(Plateau p, Noeud pere)
	{
		this.pere = pere;
		fils = new ArrayList<Noeud>();
		plateau = new Plateau(p);
		valeur_noeud = UNDEFINED;
	}
	
	//On genere les noeuds fils et on les ajoute � la liste des noeuds fils.
	public void genererFils(int token)
	{
		int[][] matrix = plateau.getPlateau();
		
		//Parmi tous les coups possibles
		for(int i = 0;i < matrix.length;i++)
		{
			for(int j = 0;j < matrix[i].length;j++)
			{
				if(matrix[i][j]!=0)
					continue;
				//Si aucun coup n'a �t� jou� � cet emplacement du plateau, on l'ajoute aux fils du noeud courant
				Noeud nouveau = new Noeud(this.plateau,this);
				nouveau.plateau.setToken(i,j,token);//On change la valeur du token � l'emplacement du plateau.
				this.fils.add(nouveau);//ajout du noeud fils aux noeuds de l'arbre.
			}
		}
	}
}
