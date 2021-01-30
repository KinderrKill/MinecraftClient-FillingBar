# Minecraft Client MCP - Barre dynamique de remplissage !

<br/>
<p align="center">
<img src=https://static.companyofcube.fr/youtube/webAssets/0e261f03c395fbf6487d553e59453513.gif width="350" height="200">
</p>

## French description

Bonjour à tous et à toutes !<br/>
Je vous propose aujourd'hui une petite classe permettant de faire une barre dynamique en fonction de deux valeurs, une maximal et une de référence. <br/>
Cela vous permet de faire des barres de progression. Sur mon propre projet j'utilise ce système pour la vie, l'expérience, la réputation et les métiers.<br/>
Vous pouvez faire pas mal de chose, il vous fait juste les imaginer ;)<br/>

### Installation

Il vous suffit de copier / coller le code de la classe `FillingBar` sur votre Client Minecraft.<br/>
NOTE : Cette classe a été faite en 1.8.0, elle reste très basique mais des fonctions peuvent ne pas être compatible ! Il vous faudras donc les remplacer par celle de votre version.<br/>

Ensuite copier les deux fonctions présentes dans la classe `GuiNewFunctions`<br/>
Et n'oubliez pas de télécharger et déplacer la texture fournise dans votre projet.<br/>
<br/>
### Utilisation

1) Pour commencer il va falloir créer un objet de base de notre barre<br/>
`FillingBar myBar = new FillingBar(positionX, positionY, largeur, hauteur, texte, texteSurvole);`<br/>

2) Ensuite définir deux valeurs pour l'affichage dynamique :<br/>
`myBar.setValue(valeurMaximal, valeurdynamique)`<br/>

3) Ajouter des options à votre guise :<br/>
`myBar.setColor(Couleur, alpha);` (Alpha pour la transparence de la texture, par défault laisser à 1.0F)<br/>
`myBar.setGlowing(Couleur, alpha);` (Alpha pour la transparence de la texture, par défault laisser à 1.0F)<br/>

4) L'affichage dans votre fonction drawScreen ou une autre méthode d'affichage d'une class qui "extend" de guiScreen<br/>
`myBar.draw(minecraft, mouseX, mouseY);` <br/>
Variable Minecraft pour l'affichage de la barre et les positions en X/Y de la souris pour le changement de texte lors du survole.<br/>
mouseX et mouseY peuvent être mis à 0 si vous ne voulez pas le changement de texte lors du survole.<br/>

______________________________________________________________________________________________________________________________________________________________________
Exemple d'une barre de vie du joueur : <br/>

`FillingBar lifeBar = new FillingBar(0, 0, 100, 20, "Vie", Minecraft.getMinecraft().thePlayer.getHealth() + "/" + Minecraft.getMinecraft().thePlayer.getMaxHealth());`<br/>

Définir les valeurs pour l'affichage dynamique :<br/>

`lifeBar.setValue(Minecraft.getMinecraft().thePlayer.getMaxHealth(), Minecraft.getMinecraft().thePlayer.getHealth());`<br/>

Et ajouter des options si vous le souhaitez :<br/>

`lifeBar.setColor(Color.YELLOW, 1.0F);`<br/>
`lifeBar.setGlowing(Color.CYAN, 1.0F);`<br/>
<br/>
Et l'étape final, l'affichage !<br/>

`lifeBar.draw(minecraft, mouseX, mouseY);`<br/>

