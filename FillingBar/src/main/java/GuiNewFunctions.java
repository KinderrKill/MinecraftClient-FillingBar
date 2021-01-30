public class GuiNewFunctions {

    public GuiNewFunctions() { }

    //Put thoses functions in Gui.java class

    // Simple copy of drawCenteredString but with static access
    public static void drawCenteredStringStatic(FontRenderer fontRendererIn, String text, int x, int y, int color)
    {
        fontRendererIn.func_175063_a(text, (float)(x - fontRendererIn.getStringWidth(text) / 2), (float)y, color);
    }

    public static void drawCustomSizedTexture(int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight)
    {
        float var8 = 1.0F / textureWidth;
        float var9 = 1.0F / textureHeight;
        Tessellator var10 = Tessellator.getInstance();
        WorldRenderer var11 = var10.getWorldRenderer();
        var11.startDrawingQuads();
        var11.addVertexWithUV((double)x, (double)(y + height), 0.0D, (double)(u * var8), (double)((v + (float)height) * var9));
        var11.addVertexWithUV((double)(x + width), (double)(y + height), 0.0D, (double)((u + (float)width) * var8), (double)((v + (float)height) * var9));
        var11.addVertexWithUV((double)(x + width), (double)y, 0.0D, (double)((u + (float)width) * var8), (double)(v * var9));
        var11.addVertexWithUV((double)x, (double)y, 0.0D, (double)(u * var8), (double)(v * var9));
        var10.draw();
    }
}
