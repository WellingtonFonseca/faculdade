import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Explore Mundo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const HomePage(),
    );
  }
}

// Página Inicial
class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Explore Mundo - Agência de Viagens'),
        backgroundColor: Colors.blueAccent,
      ),
      body: const HomeScreen(),
      bottomNavigationBar: const BottomNavBar(),
    );
  }
}

// Corpo Principal
class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: [
          // Banner de Destaque
          SizedBox(
            height: 200,
            child: PageView(
              children: const [
                BannerItem(
                    image: 'https://cdn.pixabay.com/photo/2018/04/25/09/26/eiffel-tower-3349075_1280.jpg',
                    title: 'Paris',),
                BannerItem(
                    image: 'https://cdn.pixabay.com/photo/2015/03/09/18/34/beach-666122_1280.jpg',
                    title: 'Maldivas',),
                BannerItem(
                    image: 'https://cdn.pixabay.com/photo/2014/02/22/14/16/rio-de-janeiro-272052_1280.jpg',
                    title: 'Rio de Janeiro',),
              ],
            ),
          ),
          const SizedBox(height: 20),

          // Campo de Pesquisa
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            child: TextField(
              decoration: InputDecoration(
                hintText: 'Pesquise destinos...',
                prefixIcon: const Icon(Icons.search),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(8),
                ),
              ),
            ),
          ),
          const SizedBox(height: 20),

          // Lista de Pacotes de Viagem
          const PackageList(),
        ],
      ),
    );
  }
}

// Item do Banner
class BannerItem extends StatelessWidget {
  final String image;
  final String title;

  const BannerItem({super.key, required this.image, required this.title});

  @override
  Widget build(BuildContext context) {
    return Stack(
      alignment: Alignment.center,
      children: [
        Image.network(image, fit: BoxFit.cover, width: double.infinity),
        Container(color: Colors.black.withOpacity(0.5)),
        Text(
          title,
          style: const TextStyle(
            color: Colors.white,
            fontSize: 24,
            fontWeight: FontWeight.bold,
          ),
        ),
      ],
    );
  }
}

// Lista de Pacotes
class PackageList extends StatelessWidget {
  const PackageList({super.key});

  @override
  Widget build(BuildContext context) {
    final packages = [
      {'title': 'Pacote para Paris', 'price': 'R\$ 5.000'},
      {'title': 'Pacote para Maldivas', 'price': 'R\$ 10.000'},
      {'title': 'Pacote para Rio de Janeiro', 'price': 'R\$ 1.500'},
    ];

    return ListView.builder(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      itemCount: packages.length,
      itemBuilder: (context, index) {
        final package = packages[index];
        return ListTile(
          leading: const Icon(Icons.card_travel),
          title: Text(package['title']!),
          subtitle: Text(package['price']!),
          trailing: const Icon(Icons.arrow_forward_ios),
          onTap: () {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(content: Text('Abrindo ${package['title']}')),
            );
          },
        );
      },
    );
  }
}

// Barra de Navegação Inferior
class BottomNavBar extends StatelessWidget {
  const BottomNavBar({super.key});

  @override
  Widget build(BuildContext context) {
    return BottomNavigationBar(
      items: const [
        BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Início'),
        BottomNavigationBarItem(icon: Icon(Icons.flight), label: 'Destinos'),
        BottomNavigationBarItem(
            icon: Icon(Icons.contact_page), label: 'Contato'),
      ],
    );
  }
}
