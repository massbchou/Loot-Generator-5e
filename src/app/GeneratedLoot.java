public class GeneratedLoot {

private String name;
private int lootType;
private int rarity;
private int attunement; //Spell Index: Cantrips: 0-49, 1: 50-139 2: 140-226 3: 227-304 4: 305-363 5: 364-427 6: 428-478 7: 479-507 8: 508-531 9: 532-553 
private String mainStat;
private int goldVal;
private int maxAffixes;
private int currentAffixes = 1;
private int level;
private String affixes = "";

    public GeneratedLoot(int lootType, int rarity, int level){
        this.lootType = lootType;
        this.level = level;
        this.rarity = rarity; // 1. Common 2. Uncommon 3. Rare 4. Super Rare 5. Legendary 6. Mythic
        this.attunement = ((int)Math.floor(Math.random()*(5-1+1)+1));
        if (attunement >= 2) {
            attunement = 1;
        }
        else {
            attunement = 2;
        }
        this.goldVal = ((int)Math.floor(Math.random()*(225*rarity*rarity-10*rarity*rarity+1)+10*rarity*rarity)) * attunement;
        this.mainStat = getMainStat(lootType);
        this.maxAffixes = rarity + ((int)Math.floor(Math.random()*(3-1+1)+1));
        int temp = ((int)Math.floor(Math.random()*(100-1+1)+1)) + (rarity / 3) * level / 2;
        while (temp > 35 && currentAffixes < maxAffixes) {
            currentAffixes++;
            temp = ((int)Math.floor(Math.random()*(100-1+1)+1)) + (rarity / 3) * level / 2;
        }
        for (int i = 0; i < currentAffixes; i++) {
            affixes += getAffix(lootType) + "\n";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getRarity() {
        return rarity;
    }

    public String getMainStat() {
        return mainStat;
    }

    public int getVal() {
        return goldVal;
    }

    public String attunement() {
        if (attunement == 1) {
            return "No";
        }
        else {
            return "Yes";
        }
    }

    public String getAffixes() {
        return affixes;
    }

    public int getMaxAffix() {
        return maxAffixes;
    }

    public String getAffix(int lootType) {
        switch (lootType) {
            case 1:
                return Affixes.MOaffix(rarity, level);
            case 2:
                return Affixes.ROaffix(rarity, level);
            case 3:
                return Affixes.Defaffix(rarity, level);
            case 4:
                return Affixes.Defaffix(rarity, level);
            case 5:
                return Affixes.Magiaffix(rarity, level);
            case 6:
                return Affixes.Jaffix(rarity, level);
            case 7:
                return Affixes.Poaffix(rarity, level);
            default:
                return "error";
        }
    }

    public String getMainStat(int lootType) {
        switch (lootType) {
            case 1:
                return Affixes.PhysicalMain(rarity, level);
            case 2:
                return Affixes.PhysicalMain(rarity, level);
            case 3:
                return Affixes.PhysicalDefMain(rarity, level);
            case 4:
                return Affixes.MagicalOffensiveMain(rarity, level);
            case 5:
                return Affixes.MagicalDefMain(rarity, level);
            case 6:
                return Affixes.JewleryMain(rarity, level);
            case 7:
                return Affixes.PotionMain(rarity, level);
            default:
                return "error";
        }


    }

}
