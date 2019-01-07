import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.keymap.KeymapManager
import com.intellij.openapi.keymap.ex.KeymapManagerEx
import com.intellij.openapi.ui.Messages

class QuickSwitchKeymapAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        val recentKeymap = PropertiesComponent.getInstance().getValue(Constants.RECENT_KEYMAP_KEY)

        if (!recentKeymap.isNullOrBlank()) {
            val keymapManager: KeymapManagerEx = KeymapManager.getInstance() as KeymapManagerEx

            PropertiesComponent.getInstance().setValue(Constants.RECENT_KEYMAP_KEY, keymapManager.activeKeymap.name)

            val keymap = keymapManager.getKeymap(recentKeymap)
            keymapManager.activeKeymap = keymap

            val project = event.getProject()
            Messages.showMessageDialog(project, "Toggled to: " + recentKeymap, "Greeting", Messages.getInformationIcon())
        }
    }
}