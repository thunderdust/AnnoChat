package com.chat.anno.selector;

import com.chat.anno.selector.DragController;
import com.chat.anno.selector.DragSource;

/**
 * Interface to receive notifications when a drag starts or stops
 */
public interface DragListener {
    void onDragStart(DragSource source, Object info, DragController.DragBehavior dragBehavior);
    void onDragEnd();
}
