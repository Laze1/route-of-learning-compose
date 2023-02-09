```kotlin
Text(
        text = "text",
        modifier = Modifier
            .clickable {
                Log.i("click", "点击到我了")
            }
    )
```