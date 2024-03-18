class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = bandage[0];
        int recoverySec = bandage[1];
        int recoveryBonus = bandage[2];
        int maxHealth = health;
        int prevAttack = 0;
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int dmg = attack[1];
            int healTime = attackTime - prevAttack - 1;
            health += (healTime / time) * recoveryBonus;
            health += healTime * recoverySec;
            health = health > maxHealth ? maxHealth : health;
            health -= dmg;
            if (health <= 0) {
                return -1;
            }
            prevAttack = attackTime;
        }
        return health;
    }

}