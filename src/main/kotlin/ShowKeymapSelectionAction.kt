import com.intellij.ide.actions.QuickChangeKeymapAction
import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.keymap.KeymapManager
import com.intellij.openapi.keymap.ex.KeymapManagerEx

class ShowKeymapSelectionAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        val keymapManager: KeymapManagerEx = KeymapManager.getInstance() as KeymapManagerEx

        PropertiesComponent.getInstance().setValue(Constants.RECENT_KEYMAP_KEY, keymapManager.activeKeymap.name)

        val quickChangeKeymapAction = QuickChangeKeymapAction()
        quickChangeKeymapAction.actionPerformed(event)
    }
}