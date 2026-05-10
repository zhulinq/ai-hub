# Ai Hub 项目

一个基于 Spring AI 和 Vue.js 的智能对话应用，支持 AI 聊天、PDF 文档问答、客服系统等多种功能。

## 🚀 技术栈

### 后端

* **Spring Boot 3.5.12** - Java Web 框架
* **Spring AI 1.1.3** - AI 集成框架
* **MyBatis Plus 3.5.10.1** - ORM 框架
* **MySQL** - 数据库
* **OpenAI API (阿里云通义千问)** - AI 模型服务
* **Lombok** - 简化 Java 代码
* **Java 21** - 编程语言

### 前端

* **Vue 3** - 渐进式 JavaScript 框架
* **Vite** - 构建工具
* **TypeScript** - 类型安全
* **Vue Router** - 路由管理
* **Pinia** - 状态管理
* **Naive UI** - UI 组件库
* **Marked \& Highlight.js** - Markdown 渲染和代码高亮
* **PDFTron WebViewer** - PDF 查看器

## 📋 功能特性

* ✅ **AI 智能对话** - 支持流式输出的 AI 聊天功能
* ✅ **PDF 文档问答** - 上传 PDF 文档并进行智能问答
* ✅ **客服系统** - 模拟智能客服场景
* ✅ **游戏聊天** - 游戏场景下的 AI 对话
* ✅ **舒适模拟器** - 其他 AI 应用场景
* ✅ **聊天记录管理** - 保存和查询历史对话记录
* ✅ **向量存储检索** - 基于向量数据库的文档检索

### 亮点：

* 1️⃣ 多场景 AI 应用架构

  * 智能对话系统：通用 AI 聊天助手
  * PDF 文档问答：上传 PDF 后进行智能检索和问答
  * 客服系统：集成业务工具（CourseTools），支持课程查询等实际业务场景
  * 游戏聊天：针对游戏场景定制的 AI 对话
* 2️⃣ Spring AI 高级特性应用

  * 向量存储检索（RAG）：使用 SimpleVectorStore + QuestionAnswerAdvisor 实现 PDF 文档的智能检索，支持相似度阈值（0.5）和 Top-K（2）配置
  * 多轮对话记忆：通过 MessageWindowChatMemory 实现上下文感知，最多保留 10 条历史消息
  * 流式响应：使用 Reactor Flux 实现实时流式输出，提升用户体验
  * 自定义 Advisor 链：灵活组合 Logger、Memory、VectorStore 等 Advisor
* 3️⃣ 模块化 ChatClient 设计

  * 在 CommonConfiguration 中配置了 4 个独立的 ChatClient Bean：
  * openAiChatClient：通用助手
  * gameChatClient：游戏场景
  * serviceChatClient：客服场景（集成 Tools）
  * pdfChatClient：PDF 问答（集成 VectorStore）
  * 每个 Client 都有独立的 System Prompt 和 Advisor 配置，体现了关注点分离的设计思想。
* 4️⃣ 阿里云通义千问集成

  * 使用阿里云 DashScope 兼容模式（https://dashscope.aliyuncs.com/compatible-mode）
  * 模型配置：qwen-flash（聊天）+ text-embedding-v1（嵌入）
  * 低成本、高性能的国产化 AI 方案
* 5️⃣ 完整的前后端分离架构

  * 后端：Spring Boot 3.5 + Java 21 + MyBatis-Plus
  * 前端：Vue 3 + TypeScript + Vite + Naive UI
  * 特色功能：

    * PDF 在线预览（PDFTron WebViewer）
    * Markdown 渲染 + 代码高亮
  * 聊天记录持久化（MySQL）
  * 文件上传下载管理
* 6️⃣ 业务工具集成（Function Calling）

  * 客服系统通过 CourseTools 展示了 Spring AI 的 Tool Calling 能力，AI 可以主动调用后端服务查询课程信息，实现真正的智能客服。
* 7️⃣ 生产级工程实践

  * 统一的 Result 响应封装
  * Lombok 简化代码
  * 日志级别精细化配置（org.springframework.ai: debug）
  * 文件大小限制（20MB/40MB）
  * 异常处理和错误提示

