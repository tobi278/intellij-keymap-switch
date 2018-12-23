import com.intellij.ide.actions.QuickChangeKeymapAction
import com.intellij.ide.actions.QuickSwitchSchemeAction
import com.intellij.notification.Notification
import com.intellij.notification.Notifications
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.keymap.Keymap
import com.intellij.openapi.keymap.KeymapManager
import com.intellij.openapi.keymap.ex.KeymapManagerEx
import com.intellij.openapi.ui.SelectFromListDialog
import com.intellij.util.toArray

class ShowKeymapSelectionAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        val quickChangeKeymapAction = QuickChangeKeymapAction()
        quickChangeKeymapAction.actionPerformed(event)
    }
}