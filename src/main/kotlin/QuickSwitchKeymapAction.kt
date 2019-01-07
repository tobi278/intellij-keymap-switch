import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DataKeys
import com.intellij.openapi.keymap.KeymapManager
import com.intellij.openapi.keymap.ex.KeymapManagerEx
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.ui.popup.Balloon
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.wm.WindowManager
import com.intellij.ui.awt.RelativePoint


class QuickSwitchKeymapAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        val recentKeymap = PropertiesComponent.getInstance().getValue(Constants.RECENT_KEYMAP_KEY)

        if (!recentKeymap.isNullOrBlank()) {
            val keymapManager: KeymapManagerEx = KeymapManager.getInstance() as KeymapManagerEx

            PropertiesComponent.getInstance().setValue(Constants.RECENT_KEYMAP_KEY, keymapManager.activeKeymap.name)

            val keymap = keymapManager.getKeymap(recentKeymap)
            keymapManager.activeKeymap = keymap

            val statusBar = WindowManager.getInstance()
                    .getStatusBar(DataKeys.PROJECT.getData(event.getDataContext()))

            JBPopupFactory.getInstance()
                    .createHtmlTextBalloonBuilder("Switched Keymap to: " + recentKeymap, MessageType.INFO, null)
                    .setFadeoutTime(1500)
                    .createBalloon()
                    .show(RelativePoint.getCenterOf(statusBar.component),
                            Balloon.Position.atRight)
        }
    }
}