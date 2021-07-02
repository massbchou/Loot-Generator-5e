import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;
public class UserInterface {
    public static String MOfile = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\MeleeOffensive.txt";
    public static String Adjectives = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\Adjectives.txt";
    public static String Nouns = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\Nouns.txt";
    public static String PDfile = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\PhysicalDefensive.txt";
    public static String ROfile = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\RangedOffensive.txt";
    public static String MaOfile = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\MagicalOffensive.txt";
    public static String MDfile = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\MagicalDefensive.txt";
    public static String JewleryFile = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\Jewlery.txt";
    public static String PotionFile = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\Potions.txt";
    public static String SpellFile = "C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\Spells.txt";
    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        // 1. Melee Offensive 2. Ranged Offensive 3. Physical Defensive 4. Magical Offensive 5. Magical Defensive 6. Jewlery 7. Potions
        //C:\\Users\\bchou\\OneDrive\\Documents\\My Projects\\Loot Generator 5e\\src\\app\\textfiles\\textfile
        

        

        Scanner scnr = new Scanner(System.in);
        String Input = "";
        System.out.println("Input Command");
        Input = scnr.nextLine();
        int type;
        int rarity;
        int level;
        while (Input.equals("stop") == false) {
        
            if (Input.equalsIgnoreCase("rloot")) {
                System.out.println("");
                System.out.println("");
                System.out.println("Generating Random Loot...");
                System.out.println("");
                rarity = generateRarity();
                type = (int)Math.floor(Math.random()*(7-1+1)+1);
                level = (int)Math.floor(Math.random()*(20-1+1)+1);
                GeneratedLoot loot = new GeneratedLoot(type, rarity, level);
                loot.setName(generateLootSpecific(rarity, type));
                System.out.println("Item: " + loot.getName());
                System.out.println("Main Stat: " + loot.getMainStat());
                System.out.println("");
                System.out.println("Affixes-----------------------Affixes\n" + loot.getAffixes());
                System.out.println("Requires Attunement?: " + loot.attunement());
                System.out.println("Gold Value: " + loot.getVal());
                System.out.println("Maximum Affixes: " + loot.getMaxAffix());
            }
            if (Input.equalsIgnoreCase("rspell")) {
                System.out.println("");
                System.out.println("");
                System.out.println("Getting Random Spell...");
                System.out.println(pullSpell((int)Math.floor(Math.random()*(9-0+1)+0)));
                
            }
            if (Input.equalsIgnoreCase("spell")) {
                System.out.println("");
                System.out.println("");
                System.out.println("Level?");
                Input = scnr.nextLine(); 
                System.out.println(pullSpell(Integer.valueOf(Input)));
                
            }
            if (Input.equalsIgnoreCase("clear")) {
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                
            }
            if (Input.equalsIgnoreCase("phaffix")) {

                System.out.println(Affixes.PhysicalMain((int)Math.floor(Math.random()*(6-1+1)+1), (int)Math.floor(Math.random()*(20-1+1)+1)));
                
            }
            if (Input.equalsIgnoreCase("pdaffix")) {

                System.out.println(Affixes.PhysicalDefMain((int)Math.floor(Math.random()*(6-1+1)+1), (int)Math.floor(Math.random()*(20-1+1)+1)));
                
            }
            if (Input.equalsIgnoreCase("moaffix")) {

                System.out.println(Affixes.MagicalOffensiveMain((int)Math.floor(Math.random()*(6-1+1)+1), (int)Math.floor(Math.random()*(20-1+1)+1)));
                
            }
            if (Input.equalsIgnoreCase("mdaffix")) {

                System.out.println(Affixes.MagicalDefMain((int)Math.floor(Math.random()*(6-1+1)+1), (int)Math.floor(Math.random()*(20-1+1)+1)));
                
            }
            if (Input.equalsIgnoreCase("jaffix")) {

                System.out.println(Affixes.JewleryMain((int)Math.floor(Math.random()*(6-1+1)+1), (int)Math.floor(Math.random()*(20-1+1)+1)));
                
            }
            if (Input.equalsIgnoreCase("paffix")) {

                System.out.println(Affixes.PotionMain((int)Math.floor(Math.random()*(6-1+1)+1), (int)Math.floor(Math.random()*(20-1+1)+1)));
                
            }

        System.out.println("");
        System.out.println("");
        System.out.println("Input Command");
         
        Input = scnr.nextLine(); 
        }
        
        
        
    }


    public static int countLineBufferedReader(String fileName) {

        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;

}

    public static String readSpecific(int line, String File) {
        String lineIWant = "";
        try(FileInputStream fs = new FileInputStream(File)) {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(fs))){
                for(int i = 0; i < line-1; i++){
                    br.readLine();
                }
                lineIWant = br.readLine();
            
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            } catch (Exception e) {
            e.printStackTrace();
        }
        return lineIWant;
}

    public static int generateRarity() {
        int temp = (int)Math.floor(Math.random()*(100-1+1)+1);
        int rarity;

        if (isBetween(temp, 1, 50)) {
            rarity = 1; 
        }
        else if (isBetween(temp, 51, 75)) {
            rarity = 2;
        }
        else if (isBetween(temp, 76, 87)) {
            rarity = 3;
        }
        else if (isBetween(temp, 88, 94)) {
            rarity = 4;
        }
        else if (isBetween(temp, 95, 99)) {
            rarity = 5;
        }
        else if (temp == 100) {
            rarity = 6;
        }
        else {
            rarity = 1;
        }
        return rarity;
    }

    public static String generateLootRandom() {
        int type = (int)Math.floor(Math.random()*(7-1+1)+1);
        int rarity = generateRarity();
        return generateLootSpecific(rarity, type);
    }

    public static String generateLootSpecific(int rarity, int type) {
        String loot;
        
        switch (type) {
            case 1:
                loot = generateMeleeOffensive(rarity);
            break;
            case 2:
                loot = generateRangedOffensive(rarity);
            break;
            case 3:
                loot = generatePhysicalDefensive(rarity);
            break;
            case 4:
                loot = generateMagicalOffensive(rarity);
            break;
            case 5:
                loot = generateMagicalDefensive(rarity);
            break;
            case 6:
                loot = generateJewlery(rarity);
            break;
            case 7: 
                loot = generatePotion(rarity);
            break;
            default:
                loot = "error";
         
         }

        return loot;
    }

    public static String generateMeleeOffensive(int rarity) {
        int fileLength = countLineBufferedReader(MOfile);
        String lootName = "";
        lootName += "(" + rarityTranslator(rarity) + ") ";
        if (rarity > 1) {
            lootName += readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Adjectives)-0+1)+0), Adjectives) + " ";
        }
        lootName += readSpecific((int)Math.floor(Math.random()*(fileLength-0+1)+0), MOfile);
        if (rarity > 2) {
        lootName += " of " + readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Nouns)-0+1)+0), Nouns);
        }
        return lootName;

    }

    public static String generatePhysicalDefensive(int rarity) {
        int fileLength = countLineBufferedReader(PDfile);
        String lootName = "";
        lootName += "(" + rarityTranslator(rarity) + ") ";
        if (rarity > 1) {
        lootName += readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Adjectives)-0+1)+0), Adjectives) + " ";
        }
        lootName += readSpecific((int)Math.floor(Math.random()*(fileLength-0+1)+0), PDfile);
        if (rarity > 2) {
        lootName += " of " + readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Nouns)-0+1)+0), Nouns);
        }
        
        return lootName;

    }

    public static String generateRangedOffensive(int rarity) {
        int fileLength = countLineBufferedReader(ROfile);
        String lootName = "";
        lootName += "(" + rarityTranslator(rarity) + ") ";
        if (rarity > 1) {
        lootName += readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Adjectives)-0+1)+0), Adjectives) + " ";
        }
        lootName += readSpecific((int)Math.floor(Math.random()*(fileLength-0+1)+0), ROfile);
        if (rarity > 2) {
        lootName += " of " + readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Nouns)-0+1)+0), Nouns);
        }

        return lootName;

    }

    public static String generateMagicalOffensive(int rarity) {
        int fileLength = countLineBufferedReader(MaOfile);
        String lootName = "";
        lootName += "(" + rarityTranslator(rarity) + ") ";
        if (rarity > 1) {
        lootName += readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Adjectives)-0+1)+0), Adjectives) + " ";
        }
        lootName += readSpecific((int)Math.floor(Math.random()*(fileLength-0+1)+0), MaOfile);
        if (rarity > 2) {
        lootName += " of " + readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Nouns)-0+1)+0), Nouns);
        }

        return lootName;

    }

    public static String generateMagicalDefensive(int rarity) {
        int fileLength = countLineBufferedReader(MDfile);
        String lootName = "";
        lootName += "(" + rarityTranslator(rarity) + ") ";
        if (rarity > 1) {
        lootName += readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Adjectives)-0+1)+0), Adjectives) + " ";
        }
        lootName += readSpecific((int)Math.floor(Math.random()*(fileLength-0+1)+0), MDfile);
        if (rarity > 2) {
        lootName += " of " + readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Nouns)-0+1)+0), Nouns);
        }

        return lootName;

    }

    public static String generateJewlery(int rarity) {
        int fileLength = countLineBufferedReader(JewleryFile);
        String lootName = "";
        lootName += "(" + rarityTranslator(rarity) + ") ";
        if (rarity > 1) {
        lootName += readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Adjectives)-0+1)+0), Adjectives) + " ";
        }
        lootName += readSpecific((int)Math.floor(Math.random()*(fileLength-0+1)+0), JewleryFile);
        if (rarity > 2) {
        lootName += " of " + readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Nouns)-0+1)+0), Nouns);
        }
        return lootName;

    }

    public static String generatePotion(int rarity) {
        int fileLength = countLineBufferedReader(PotionFile);
        String lootName = "";
        lootName += "(" + rarityTranslator(rarity) + ") ";
        if (rarity > 1) {
        lootName += readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Adjectives)-0+1)+0), Adjectives) + " ";
        }
        lootName += readSpecific((int)Math.floor(Math.random()*(fileLength-0+1)+0), PotionFile) + " Potion";
        if (rarity > 2) {
        lootName += " of " + readSpecific((int)Math.floor(Math.random()*(countLineBufferedReader(Nouns)-0+1)+0), Nouns);
        }
        
        return lootName;

    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    public static String pullSpell(int level) {
        String spell = "";
        int ceiling = 0;
        int floor = 0;
        
        switch (level) {
            case 0:
                ceiling = 49;
                floor = 0;
                break;
            case 1:
                ceiling = 139;
                floor = 50;
                break;
            case 2:
                ceiling = 226;
                floor = 140;
                break;
            case 3:
                ceiling = 304;
                floor = 227;
                break;
            case 4:
                ceiling = 363;
                floor = 305;
                break;
            case 5:
                ceiling = 427;
                floor = 364;
                break;
            case 6:
                ceiling = 478;
                floor = 428;
                break;
            case 7:
                ceiling = 507;
                floor = 479;
                break;
            case 8:
                ceiling = 531;
                floor = 508;
                break;
            default:
                ceiling = 554;
                floor = 532;

        }
        
        spell += readSpecific((int)Math.floor(Math.random()*(ceiling-floor+1)+floor), SpellFile);
        


        return spell;
    }

    public static String rarityTranslator(int rarity) {
        switch (rarity) {
            case 1:
                return "Common";
            case 2:
                return "Uncommon";
            case 3: 
                return "Rare";
            case 4:
                return "Epic";
            case 5: 
                return "Legendary";
            case 6:
                return "Mythic";
            default:
                return "Error";
        }


    }

}
