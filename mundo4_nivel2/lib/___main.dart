import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'ListView com ListTile',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Lista com ListView'),
          backgroundColor: Colors.blueAccent,
        ),
        body: const ListaExemplo(), // Chamada do Widget personalizado
      ),
    );
  }
}

class ListaExemplo extends StatelessWidget {
  const ListaExemplo({super.key});

  @override
  Widget build(BuildContext context) {
    return ListView(
      children: const [
        // Item 1
        ListTile(
          leading: Icon(Icons.flash_on, color: Colors.yellow), // Ícone à esquerda
          title: Text('Flutter'), // Título do item
          subtitle: Text('Tudo é um widget'), // Subtítulo
          trailing: Icon(Icons.keyboard_arrow_right), // Ícone à direita
        ),
        Divider(), // Linha separadora

        // Item 2
        ListTile(
          leading: Icon(Icons.mood, color: Colors.green),
          title: Text('Dart'),
          subtitle: Text('É fácil'),
          trailing: Icon(Icons.keyboard_arrow_right),
        ),
        Divider(),

        // Item 3
        ListTile(
          leading: Icon(Icons.whatshot, color: Colors.red),
          title: Text('Firebase'),
          subtitle: Text('Combina com Flutter'),
          trailing: Icon(Icons.keyboard_arrow_right),
        ),
        Divider(),
      ],
    );
  }
}
