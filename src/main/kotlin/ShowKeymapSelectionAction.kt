import com.intellij.ide.actions.QuickChangeKeymapAction
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ShowKeymapSelectionAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        val quickChangeKeymapAction = QuickChangeKeymapAction()
        quickChangeKeymapAction.actionPerformed(event)
    }
}