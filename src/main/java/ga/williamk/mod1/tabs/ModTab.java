package ga.williamk.mod1.tabs;

import ga.williamk.mod1.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs {
    private String title = "";
    private boolean hoveringButton = false;

    public ModTab(String label) {
        super(label);
    }

    @Override
    public CreativeTabs setBackgroundImageName(String texture) {
        return super.setBackgroundImageName(texture);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.AXE_ROYAL);
    }

    @Override
    public String getTranslatedTabLabel() {
        return hoveringButton ? title : "Mod1 Stuff";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHoveringButton(boolean hoveringButton) {
        this.hoveringButton = hoveringButton;
    }

}