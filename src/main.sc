require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Молви друг и войди!

        state: Melon
        intent!: Melon
        a: Входите! Вы вошли в подземелье Мориию. Перед вами три коридора.
        a:Ваши действия

        state: Left
        q: * *лев* *
        a: Вас съел дракон
        
        state: Right
        q: * *прав* *
        a: Перед вами сундук. Ваши действия?
            
            state: Open
            q: открыть
            a: В сундуке монеты, {{getRandomInt(10)}} штук
        
        state: Straight
        q: * *прям* *
        a: Чтобы выжить вам нужно сыграть в камень ножницы бумага. Играем?
        
        state: Back
        q: (назад|~вернуться|~вернуть|~возвращаться)*
        a:Вход завалило. Выберите другое направление.
        
    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

        state: Match
        event!: match
        a: {{$context.intent.answer}}