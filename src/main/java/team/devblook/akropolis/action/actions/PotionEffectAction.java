package team.devblook.akropolis.action.actions;

import com.cryptomorin.xseries.XPotion;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import team.devblook.akropolis.AkropolisPlugin;
import team.devblook.akropolis.action.Action;

import java.util.Optional;

public class PotionEffectAction implements Action {

    @Override
    public String getIdentifier() {
        return "EFFECT";
    }

    @Override
    public void execute(AkropolisPlugin plugin, Player player, String data) {
        String[] args = data.split(";");
        Optional<XPotion> xpotion = XPotion.matchXPotion(args[0]);

        try {
            xpotion.ifPresent(p -> {
                PotionEffect potionEffect = p.buildPotionEffect(1000000, Integer.parseInt(args[1]) - 1);

                if (potionEffect == null) throw new IllegalStateException();

                player.addPotionEffect(potionEffect);
            });
        } catch (Exception e) {
            plugin.getLogger().warning("[Akropolis Action] Invalid potion effect name: " + data.toUpperCase());
        }
    }
}