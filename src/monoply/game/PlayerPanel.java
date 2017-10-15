/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monoply.game;

/**
 *
 * @author mahmoud
 */
class playerPanel {
    

    public void updatePanel() {
        playerMoneyLbl.setText("Money : " + player.money);
        playerCountriesComboBox.removeAllItems();
        
        CountriesGroup[] groups = player.getGroupsArray();
        
        if(groups == null) {
            System.out.println("hello");
        }
        
        for(int i = 0; i < groups.length; i++) {
            ArrayList<Country> countries = groups[i].getCountries();
            for(int j = 0; j < countries.size(); j++) {
                playerCountriesComboBox.addItem(countries.get(j).getName());
            }
        }
        
        for(int i = 0; i < player.getProperties().size(); i++) {
           playerCountriesComboBox.addItem(player.getProperties().get(i).getName()); 
        }
    }
    
    public String getSelectedItem() {
        return (String)playerCountriesComboBox.getSelectedItem();
    }
}
