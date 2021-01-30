package package;

import javafx.scene.paint.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class FillingBar {

    private final ResourceLocation FILLED_BAR_TEXTURE = new ResourceLocation("textures/misc/ui_dynamic_bar.png");
    private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");

    private final int posX;
    private final int posY;

    private final int height;
    private final int width;

    private int maxValue;
    private int actualValue;

    private final String text;
    private final String hoveredText;

    private Color color;
    private float alpha;

    private boolean glowing;
    private Color glowingColor;
    private float glowingAlpha;

    /*
     USAGE in drawScreen function of a GUI of other extended class of guiScreen :
      FillingBar myBar = new FillingBar(posX, posY, sizeWidth, sizeHeight, normalText, hoveredText);
       // Set values of the bar exemple (100, 50) the bar gonna be draw at 50% of the full texture define by sizeWidth.
       myBar.setValue(maxValue, value);

       // Extra options Color & Alpha for transparency
        myBar.setColor(Color.YELLOW, 1.0F);

       // Extra option : Sexy glowing effect with Color & Alpha for transparency
       myBar.setGlowing(Color.CYAN, 1.0F);

       // FINAL STEP ! mouseX & mouseY is for hoveredText.
       myBar.draw(minecraft, mouseX, mouseY);
     */
    public FillingBar(int posX, int posY, int width, int height, String text, String hoveredText) {
        this.posX = posX;
        this.posY = posY;

        this.width = width;
        this.height = height;

        this.text = text;
        this.hoveredText = hoveredText;

        this.color = null;
        this.alpha = 1.0F;
        this.glowingColor = null;
    }

    public GuiFillingBar setValues(int maxValue, int actualValue) {
        this.maxValue = maxValue;
        this.actualValue = actualValue;
        return this;
    }

    public GuiFillingBar setColor(Color color, float alpha) {
        this.color = color;
        this.alpha = alpha;
        return this;
    }

    public GuiFillingBar setGlowing(Color glowingColor, float glowingAlpha) {
        this.glowing = true;
        this.glowingColor = glowingColor;
        this.glowingAlpha = glowingAlpha;
        return this;
    }

    public void draw(Minecraft minecraft, int mouseX, int mouseY) {
        minecraft.getTextureManager().bindTexture(FILLED_BAR_TEXTURE);
        if (color != null) GlStateManager.color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), alpha);

        int actualPixelState = actualValue * width / maxValue;

        Gui.drawCustomSizedTexture(posX, posY, 0, 2, actualPixelState, height - 9, width, height);

        GlStateManager.color(1F, 1F, 1F, 1F);

        boolean pointsDragged = mouseX >= posX && mouseY >= posY && mouseX < posX + width && mouseY < posY + height - 9;
        Gui.drawCenteredStringStatic(minecraft.fontRendererObj, pointsDragged ? hoveredText : text, posX + 26, posY + 2, -1);

        if(glowing) {
            GlStateManager.depthMask(false);
            GlStateManager.depthFunc(514);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(768, 1);
            minecraft.getTextureManager().bindTexture(RES_ITEM_GLINT);
            GlStateManager.matrixMode(5890);

            GlStateManager.pushMatrix();
            float scale = 0.8F;
            GlStateManager.scale(scale, scale, scale);
            float var2 = (float) (Minecraft.getSystemTime() % 3600L) / 3600.0F / 0.8F;
            GlStateManager.translate(-var2, 0.0F, 0.0F);
            GlStateManager.rotate(20.0F, 0.0F, 0.0F, 1.0F);
            if(glowingColor != null) GlStateManager.color((float) glowingColor.getRed(), (float) glowingColor.getGreen(), (float) glowingColor.getBlue(), glowingAlpha);
            Gui.drawCustomSizedTexture(posX, posY, 0, 2, actualPixelState, height - 9, width, height);
            GlStateManager.popMatrix();
        }
    }
}
