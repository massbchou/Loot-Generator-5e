public class Affixes {
    
    public static String PhysicalMain(int rarity, int level) {
        double top = rarity / 1.5 * level / 3.0; 

        return "Deals " + ((int)Math.floor(Math.random()*(top-1+1)+1)) + " additional damage. \nItem Level: " + level;
    }

    public static String PhysicalDefMain(int rarity, int level) {
        double top = rarity / 2.0 + level / 10.0; 

        return "Additional " + ((int)Math.floor(Math.random()*(top-1+1)+1)) + " AC. \nItem Level: " + level;
    }

    public static String MagicalOffensiveMain(int rarity, int level) {
        double top = rarity / 1.2 * level / 2.3; 
        double min = level / 5.0;

        return "Deals " + ((int)Math.floor(Math.random()*(top-min+1)+min)) + " additional spell attack damage. \nItem Level: " + level;
    }

    public static String MagicalDefMain(int rarity, int level) {
        double top = rarity / 2.5 + level / 10.5; 

        return "Additional " + ((int)Math.floor(Math.random()*(top-1+1)+1)) + " AC. \nItem Level: " + level;
    }

    public static String JewleryMain(int rarity, int level) {
        double top = rarity / 2.5 + level / 10; 

        return "Gain +" + ((int)Math.floor(Math.random()*(top-1+1)+1)) + " to " + raScore() + " checks. \nItem Level: " + level;
    }

    public static String PotionMain(int rarity, int level) {
        double top = rarity * level * 3;

        return "Duration: " + ((int)Math.floor(Math.random()*(top-10+1)+10)) + " minutes. \nItem Level: " + level;
    }

    public static String rdmgType() {
        int temp = ((int)Math.floor(Math.random()*(13-1+1)+1));

        switch (temp) {
            case 1:
                return "acid";
            case 2:
                return "bludgeoning";
            case 3:
                return "cold";
            case 4:
                return "fire";
            case 5:
                return "force";
            case 6:
                return "lightning";
            case 7: 
                return "necrotic";
            case 8: 
                return "piercing";
            case 9: 
                return "poison";
            case 10: 
                return "psychic";
            case 11: 
                return "radiant";
            case 12: 
                return "slashing";
            case 13: 
                return "thunder";
            default: 
                return "error";
        }
    }
    public static String raScore() {
        int temp = ((int)Math.floor(Math.random()*(6-1+1)+1));

        switch (temp) {
            case 1:
                return "strength";
            case 2:
                return "dexterity";
            case 3:
                return "constitution";
            case 4:
                return "intelligence";
            case 5:
                return "wisdom";
            case 6:
                return "charisma";
            default: 
                return "error";
        }
    }

    public static String rCondition() {
        int temp = ((int)Math.floor(Math.random()*(15-1+1)+1));

        switch (temp) {
            case 1:
                return "blinded";
            case 2:
                return "charmed";
            case 3:
                return "deafened";
            case 4:
                return "frightened";
            case 5:
                return "grappled";
            case 6:
                return "incapacitated";
            case 7:
                return "invisible";
            case 8:
                return "paralyzed";
            case 9:
                return "petrified";
            case 10:
                return "poisoned";
            case 11:
                return "prone";
            case 12:
                return "restrained";
            case 13:
                return "stunned";
            case 14:
                return "unconscious";
            case 15:
                return "exhaustion";
            default: 
                return "error";
        }
    }

    public static String MOaffix(int rarity, int level) {
        String affix = "";
        int tier = getTier(rarity, level);
        int temp;

            switch (tier) {
                case 1:
                    temp = ((int)Math.floor(Math.random()*(4-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Increases " + rdmgType() + " damage by " + ((int)Math.floor(Math.random()*(level*1.5-1+1)+1));
                        case 2: 
                            return "Increases movement speed by " + ((int)Math.floor(Math.random()*((level-1+1)+1))) * 5;
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(0) + " at will";
                        default:
                            return "You may cast " + UserInterface.pullSpell(1) + " once per day";

                    }
                case 2:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +1 bonus to attack and damage rolls";
                        case 2: 
                            return "Grants 1 use of second wind";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(1) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(2) + " once per day";
                        case 5:
                            return "Grants +1 to " + raScore();
                        case 6: 
                            int x = ((int)Math.floor(Math.random()*(3-1+1)+1));
                            switch (x) {
                                case 1:
                                    return "Has the effect of the Dueling fighting style";
                                case 2: 
                                    return "Has the effect of Two Weapon Fighting";
                                case 3:
                                    return "has the effect of Great Weapon Fighting";
                            }   
                    }
                case 3:
                    temp = ((int)Math.floor(Math.random()*(7-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +2 bonus to attack and damage rolls";
                        case 2: 
                            return "Critical Range +1";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(2) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(4-3+1)+3))) + " once per day";
                        case 5:
                            return "Attacks deal an additional " + ((int)Math.floor(Math.random()*(level-1+1)+1)) + " " + rdmgType() + " damage";
                        case 6: 
                            return "Grants the effects of the Sentinel Feat";
                        case 7:
                            return "Grants the effects of the Savage Attacker Feat";
                    }
                break;
                case 4:
                    temp = ((int)Math.floor(Math.random()*(8-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +2 to " + raScore();
                        case 2: 
                            return "Grants 1 use of Action Surge";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(4-3+1)+3))) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(5) + " once per day";
                        case 5:
                            return "Attack Range Increased by 5 feet";
                        case 6: 
                            return "Grants 1 Extra Attack";
                        case 7:
                            return "Critical Multiple +1";
                        case 8: 
                            return "Regain HP equal to 25% of damage dealt with this weapon";
                    }
                break;
                case 5:
                    temp = ((int)Math.floor(Math.random()*(8-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +3 bonus to attack and damage rolls";
                        case 2: 
                            return "This Item uses Exploding Dice";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(5) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(6) + " once per day";
                        case 5:
                            return "Critical Range +2";
                        case 6: 
                            return "Grants 1 use of Idomitable";
                        case 7:
                            return "Critical Multiple x2";
                        case 8: 
                            return "Regain HP equal to 50% of damage dealt with this weapon";
                    }
                break;
                case 6:
                    temp = ((int)Math.floor(Math.random()*(7-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +4 bonus to attack and damage rolls";
                        case 2: 
                            return "This item bypasses resistances";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(6) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(7) + " once per day";
                        case 5:
                            return "Critical Range +4";
                        case 6: 
                            return "Grants +3 to " + raScore();
                        case 7: 
                            return "Regain HP equal to the damage dealt with this weapon";
                    }
                break;
                case 7:
                    temp = ((int)Math.floor(Math.random()*(8-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +5 bonus to attack and damage rolls";
                        case 2: 
                            return "This item bypasses immunities";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(7) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(9-8+1)+8))) + " once per day";
                        case 5:
                            return "Critical Range +5";
                        case 6: 
                            return "Grants +2 to all physical ability scores";
                        case 7: 
                            return "Critical Multiple +3";
                        case 8:
                            return "Grants 2 Extra Attacks";
                    }
                break;
                case 8:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "This item has advantage on all attacks it makes";
                        case 2: 
                            return "Grants +6 to " + raScore();
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(9-8+1)+8))) + " at will";
                        case 4:
                            return "Critical Multiple +5";
                        case 5:
                            return "Critical Range +10";
                        case 6: 
                            return "Grants 3 Extra Attacks";
                    }
                break;
                default:
                return "error";
                
            }

        return affix;
    }

    public static String ROaffix(int rarity, int level) {
        String affix = "";
        int tier = getTier(rarity, level);
        int temp;

            switch (tier) {
                case 1:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Increases " + rdmgType() + " damage by " + ((int)Math.floor(Math.random()*(level*1.5-1+1)+1));
                        case 2: 
                            return "Increases movement speed by " + ((int)Math.floor(Math.random()*((level-1+1)+1))) * 5;
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(0) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(1) + " once per day";
                        case 5:
                            return "This weapon has +1 to attacks";
                        case 6:
                            return "Weapon Range Increased by " + rarity * level * 5 + " feet";

                    }
                case 2:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +1 bonus to attack and damage rolls";
                        case 2: 
                            return "Critical Multiple +1";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(1) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(2) + " once per day";
                        case 5:
                            return "Grants +1 to " + raScore();
                        case 6: 
                            return "Grants the Archery fighting style";  
                    }
                case 3:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +2 bonus to attack and damage rolls";
                        case 2: 
                            return "Critical Range +2";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(2) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(4-3+1)+3))) + " once per day";
                        case 5:
                            return "Attacks deal an additional " + ((int)Math.floor(Math.random()*(level-1+1)+1)) + " " + rdmgType() + " damage";
                        case 6: 
                            return "Grants the effects of the Sharpshooter Feat";
                    }
                break;
                case 4:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +2 to " + raScore();
                        case 2: 
                            return "Attacks from this weapon pierce 1 creature";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(4-3+1)+3))) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(5) + " once per day";
                        case 5:
                            return "Critical Multiple +2";
                        case 6: 
                            return "Grants 1 Extra Attack";
                    }
                break;
                case 5:
                    temp = ((int)Math.floor(Math.random()*(7-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +3 bonus to attack and damage rolls";
                        case 2: 
                            return "This Item uses Exploding Dice";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(5) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(6) + " once per day";
                        case 5:
                            return "Critical Range x3";
                        case 6: 
                            return "Attacks from this weapon pierce 2 creatures";
                        case 7:
                            return "Critical Multiple x4";
                    }
                break;
                case 6:
                    temp = ((int)Math.floor(Math.random()*(7-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +4 bonus to attack and damage rolls";
                        case 2: 
                            return "This item bypasses resistances";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(6) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(7) + " once per day";
                        case 5:
                            return "Critical Range +5";
                        case 6: 
                            return "Grants +3 to " + raScore();
                        case 7: 
                            return "Attacks from this weapon pierce 3 creatures";
                    }
                break;
                case 7:
                    temp = ((int)Math.floor(Math.random()*(8-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants a +5 bonus to attack and damage rolls";
                        case 2: 
                            return "This item bypasses immunities";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(7) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(9-8+1)+8))) + " once per day";
                        case 5:
                            return "Critical Range +7";
                        case 6: 
                            return "Grants +2 to all physical ability scores";
                        case 7: 
                            return "Critical Multiple +5";
                        case 8:
                            return "Grants 2 Extra Attacks";
                    }
                break;
                case 8:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "This item has advantage on all attacks it makes";
                        case 2: 
                            return "Grants +6 to " + raScore();
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(9-8+1)+8))) + " at will";
                        case 4:
                            return "Critical Multiple +7";
                        case 5:
                            return "Critical Range +12";
                        case 6: 
                            return "Grants 3 Extra Attacks";
                    }
                break;
                default:
                return "error";
                
            }

        return affix;
    }

    public static String Defaffix(int rarity, int level) {
        String affix = "";
        int tier = getTier(rarity, level);
        int temp;

            switch (tier) {
                case 1:
                    temp = ((int)Math.floor(Math.random()*(4-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Reduces " + rdmgType() + " damage taken by " + ((int)Math.floor(Math.random()*(level/1.5-1+1)+1));
                        case 2: 
                            return "Increases movement speed by " + ((int)Math.floor(Math.random()*((level-1+1)+1))) * 5;
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(0) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(1) + " once per day";
                    }
                case 2:
                    temp = ((int)Math.floor(Math.random()*(5-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants " + (int)Math.floor(Math.random()*((level * rarity -1+1)+1)) + 1 + " additional hitpoints";
                        case 2: 
                            return "Grants a " + level / 5 + " bonus to initative rolls";  
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(1) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(2) + " once per day";
                        case 5:
                            return "Grants +1 to " + raScore();
                    }
                case 3:
                    temp = ((int)Math.floor(Math.random()*(5-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +1 to " + raScore() + " saving throws";
                        case 2: 
                            return "AC +1";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(2) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(4-3+1)+3))) + " once per day";
                        case 5:
                            return "Advantage on saving throws against the " + rCondition() + " condition";
                    }
                break;
                case 4:
                    temp = ((int)Math.floor(Math.random()*(5-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +2 to " + raScore();
                        case 2: 
                            return "Grants " + (int)Math.floor(Math.random()*((level * rarity * 2.5 -1+1)+1)) + 10 + " additional hitpoints";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(4-3+1)+3))) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(5) + " once per day";
                        case 5:
                            return "Grants resistance to " + rdmgType();
                    }
                break;
                case 5:
                    temp = ((int)Math.floor(Math.random()*(5-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "AC +2";
                        case 2: 
                            return "Grants advantage on " + raScore() + " saving throws";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(5) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(6) + " once per day";
                        case 5:
                            return "Immunity to the " + rCondition() + " condition";
                    }
                break;
                case 6:
                    temp = ((int)Math.floor(Math.random()*(5-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +3 to " + raScore();
                        case 2: 
                            return "AC +3";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(6) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(7) + " once per day";
                        case 5:
                            return "Grants " + (int)Math.floor(Math.random()*((level * rarity * level / 2 -1+1)+1)) + 25 + " additional hitpoints";
                    }
                break;
                case 7:
                    temp = ((int)Math.floor(Math.random()*(5-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "You are immune to " + rdmgType() + " damage";
                        case 2: 
                            return "You take " + ((int)Math.floor(Math.random()*(level-1+1)+1)) + 1 + " less damage from all sources";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(7) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(9-8+1)+8))) + " once per day";
                        case 5:
                            return "Critical hits against you become normal hits";
                    }
                break;
                case 8:
                    temp = ((int)Math.floor(Math.random()*(4-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants " + (int)Math.floor(Math.random()*((level * rarity * level * rarity / 1.5 -1+1)+1)) + 50 + " additional hitpoints";
                        case 2: 
                            return "Grants +6 to " + raScore();
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(9-8+1)+8))) + " at will";
                        case 4:
                            return "Attacks against you have disadvantage";
                    }
                break;
                default:
                return "error";
                
            }

        return affix;
    }

    public static String Magiaffix(int rarity, int level) {
        String affix = "";
        int tier = getTier(rarity, level);
        int temp;

            switch (tier) {
                case 1:
                    temp = ((int)Math.floor(Math.random()*(4-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Increases " + rdmgType() + " damage by " + ((int)Math.floor(Math.random()*(level * 1.5-1+1)+1));
                        case 2: 
                            return "Increases movement speed by " + ((int)Math.floor(Math.random()*((level-1+1)+1))) * 5;
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(0) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(1) + " once per day";
                    }
                case 2:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +1 to spell attacks";
                        case 2: 
                            return "Grants a level " + (int)Math.floor(Math.random()*((3-1+1)+1)) + " spell slot";  
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(1) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(2) + " once per day";
                        case 5:
                            return "Grants +1 to " + raScore();
                        case 6: 
                            return "Grants 1 versatile sorcery point";
                    }
                case 3:
                    temp = ((int)Math.floor(Math.random()*(9-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +2 to spell attacks";
                        case 2: 
                            return "+1 to spell save DC";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(2) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(4-3+1)+3))) + " once per day";
                        case 5:
                            return "Spells deal " + (int)Math.floor(Math.random()*((level/2-1+1)+1)) + " additional " + rdmgType() + " damage";
                        case 6:
                            return "Grants the Spell Sniper feat";
                        case 7:
                            return "Grants the War Caster feat";
                        case 8:
                            return "Grants a level " + (int)Math.floor(Math.random()*((6-4+1)+4)) + " spell slot";  
                        case 9:
                            return "Grants " + (int)Math.floor(Math.random()*((rarity-1+1)+1)) + 1 + " versatile sorcery points";
                    }
                break;
                case 4:
                    temp = ((int)Math.floor(Math.random()*(7-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +2 to " + raScore();
                        case 2: 
                            return "Spell Range is Doubled";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(4-3+1)+3))) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(5) + " once per day";
                        case 5:
                            return "Grants +3 to spell attacks";
                        case 6: 
                            return "Grants a level " + (int)Math.floor(Math.random()*((8-7+1)+7)) + " spell slot";  
                        case 7:
                            return "Grants " + (int)Math.floor(Math.random()*((level-1+1)+1)) + 2 + " versatile sorcery points";
                    }
                break;
                case 5:
                    temp = ((int)Math.floor(Math.random()*(7-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +4 to spell attacks";
                        case 2: 
                            return "+2 to spell save DC";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(5) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(6) + " once per day";
                        case 5:
                            return "Double Spell Duration";
                        case 6:
                            return "Your spells are permanently upcasted by 1";
                        case 7:
                            return "Grants a level 9 spell slot";
                    }
                break;
                case 6:
                    temp = ((int)Math.floor(Math.random()*(8-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Grants +3 to " + raScore();
                        case 2: 
                            return "Grants +5 to spell attacks";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(6) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(7) + " once per day";
                        case 5:
                            return "Your save spells can crit";
                        case 6:
                            return "Your spells bypass resistances";
                        case 7:
                            return "+4 to spell save DC";
                        case 8:
                            return "This item can cast 2 additional leveled spells per turn";
                    }
                break;
                case 7:
                    temp = ((int)Math.floor(Math.random()*(6-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "Your spells bypass immunities";
                        case 2: 
                            return "Grants +2 to all mental ability scores";
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(7) + " at will";
                        case 4:
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(9-8+1)+8))) + " once per day";
                        case 5:
                            return "Your spell casting times decrease by 1 stage";
                        case 6:
                            return "Spell range x10";
                    }
                break;
                case 8:
                    temp = ((int)Math.floor(Math.random()*(7-1+1)+1));
                    switch (temp) {
                        case 1:
                            return "+10 to spell attacks";
                        case 2: 
                            return "Grants +6 to " + raScore();
                        case 3: 
                            return "You may cast " + UserInterface.pullSpell(((int)Math.floor(Math.random()*(9-8+1)+8))) + " at will";
                        case 4:
                            return "Spell save DC +6";
                        case 5:
                            return "Your spells are permanent";
                        case 6:
                            return "Spell range x100";
                        case 7:
                            return "You are unaffected by your own spells";
                    }
                break;
                default:
                return "error";
                
            }

        return affix;
    }

    public static String Jaffix(int rarity, int level) {
        int temp = ((int)Math.floor(Math.random()*(4-1+1)+1));

        switch (temp) {
            case 1:
                return MOaffix(rarity, level);
            case 2:
                return ROaffix(rarity, level);
            case 3:
                return Defaffix(rarity, level);
            case 4:
                return Magiaffix(rarity, level);
            default:
                return "error";
        }


    }
    
    public static String Poaffix(int rarity, int level) {
        int x = ((int)Math.floor(Math.random()*(10-1+1)+1));

        if (x >= 3) {
            int temp = ((int)Math.floor(Math.random()*(4-1+1)+1));

            switch (temp) {
                case 1:
                    return MOaffix(rarity, level);
                case 2:
                    return ROaffix(rarity, level);
                case 3:
                    return Defaffix(rarity, level);
                case 4:
                    return Magiaffix(rarity, level);
                default:
                    return "error";
            }
        }
        else {
            String affix = "";
            int tier = getTier(rarity, level);
            int temp;
    
                switch (tier) {
                    case 1:
                        return "Duration x1.5";
                    case 2:
                        temp = ((int)Math.floor(Math.random()*(2-1+1)+1));
                        switch (temp) {
                            case 1:
                                return "Duration x2";
                            case 2: 
                                return "Base Potion Effects x2";  
                        }
                    case 3:
                        temp = ((int)Math.floor(Math.random()*(3-1+1)+1));
                        switch (temp) {
                            case 1:
                                return "Other affixes effects x2";
                            case 2: 
                                return "Duration x3";
                            case 3: 
                                return "Base Potion Effects x3";
                        }
                    break;
                    case 4:
                        temp = ((int)Math.floor(Math.random()*(3-1+1)+1));
                        switch (temp) {
                            case 1:
                                return "Duration x5";
                            case 2: 
                                return "Base Potion Effects x5";
                            case 3: 
                                return "Other affixes effects x3";
                        }
                    break;
                    case 5:
                        temp = ((int)Math.floor(Math.random()*(3-1+1)+1));
                        switch (temp) {
                            case 1:
                                return "Duration x10";
                            case 2: 
                                return "Base Potion Effects x10";
                            case 3: 
                                return "Other affixes effects x4";
                        }
                    break;
                    case 6:
                        temp = ((int)Math.floor(Math.random()*(2-1+1)+1));
                        switch (temp) {
                            case 1:
                                return "Potion Lasts 1 day";
                            case 2: 
                                return "Potions affects allies within 30 ft";
                        }
                    break;
                    case 7:
                        temp = ((int)Math.floor(Math.random()*(2-1+1)+1));
                        switch (temp) {
                            case 1:
                                return "Potion is Permanent until dispelled";
                            case 2: 
                                return "Base Potion Effects x20";
                        }
                    break;
                    case 8:
                        temp = ((int)Math.floor(Math.random()*(3-1+1)+1));
                        switch (temp) {
                            case 1:
                                return "Potion is permanent and cannot be dispelled";
                            case 2: 
                                return "Base Potion Effects x100";
                            case 3: 
                                return "Other affixes effects x10";
                        }
                    break;
                    default:
                    return "error";
                    
                }
    
            return affix;    
        }


    }

    public static int getTier(int rarity, int level) {
        int temp = ((int)Math.floor(Math.random()*(100-1+1)+1));
        int tier;

        switch (rarity) {
            case 2:
                temp += 5;
                break;
            case 3:
                temp += 10;
                break;
            case 4:
                temp += 20;
                break;
            case 5:
                temp += 25;
                break;
            case 6:
                temp += 30;
                break;
            default: 
                temp += 0;
        }
        temp += level / 3;

        if (UserInterface.isBetween(temp, 1, 50)) {
            tier = 1; 
        }
        else if (UserInterface.isBetween(temp, 51, 80)) {
            tier = 2;
        }
        else if (UserInterface.isBetween(temp, 81, 90)) {
            tier = 3;
        }
        else if (UserInterface.isBetween(temp, 91, 98)) {
            tier = 4;
        }
        else if (UserInterface.isBetween(temp, 99, 110)) {
            tier = 5;
        }
        else if (UserInterface.isBetween(temp, 111, 119)) {
            tier = 6;
        }
        else if (UserInterface.isBetween(temp, 120, 129)) {
            tier = 7;
        }
        else if (temp >= 130) {
            tier = 8;
        }
        else {
            tier = 1;
        }
        return tier;

    }



}
