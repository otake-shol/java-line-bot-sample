/*
 * Copyright 2018 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.example.javalinebotsample;

import com.linecorp.bot.model.action.*;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MessageWithQuickReplySupplier implements Supplier<Message> {
    @Override
    public Message get() {
        final List<QuickReplyItem> items = Arrays.<QuickReplyItem>asList(
                QuickReplyItem.builder()
                              .action(new MessageAction("MessageAction", "MessageAction"))
                              .build(),
                QuickReplyItem.builder()
                              .action(CameraAction.withLabel("CameraAction"))
                              .build(),
                QuickReplyItem.builder()
                              .action(CameraRollAction.withLabel("CemeraRollAction"))
                              .build(),
                QuickReplyItem.builder()
                              .action(LocationAction.withLabel("Location"))
                              .build(),
                QuickReplyItem.builder()
                              .action(PostbackAction.builder()
                                                    .label("PostbackAction")
                                                    .text("PostbackAction clicked")
                                                    .data("{PostbackAction: true}")
                                                    .build())
                              .build()
        );

        final QuickReply quickReply = QuickReply.items(items);

        return TextMessage
                .builder()
                .text("Message with QuickReply")
                .quickReply(quickReply)
                .build();
    }
}
