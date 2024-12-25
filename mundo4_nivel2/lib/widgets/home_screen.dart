import 'package:flutter/material.dart';
import 'banner_item.dart';
import 'package_list.dart';
import 'bottom_nav_bar.dart';
import 'title_section.dart';
import 'text_section.dart';
import 'button_section.dart';
import 'search_bar.dart';
import 'image_section.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final PageController _pageController = PageController();

  List<Map<String, String>> filteredPackages = [];
  final List<Map<String, String>> packages = [
    {'title': 'Pacote para Paris', 'price': '5000'},
    {'title': 'Pacote para Maldivas', 'price': '10000'},
    {'title': 'Pacote para Rio de Janeiro', 'price': '1500'},
  ];

  @override
  void initState() {
    super.initState();

    // Alternar imagens automaticamente no banner
    Future.delayed(const Duration(seconds: 4), () {
      _pageController.nextPage(
          duration: const Duration(milliseconds: 500), curve: Curves.easeInOut);
    });

    filteredPackages = packages;
  }

  void _filterPackages(String query) {
    setState(() {
      if (query.isEmpty) {
        filteredPackages = packages;
      } else {
        filteredPackages = packages
            .where((pkg) =>
                pkg['title']!.toLowerCase().contains(query.toLowerCase()))
            .toList();
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Explore Mundo - Agência de Viagens'),
        backgroundColor: Colors.blueAccent,
      ),
      body: ListView(
        children: [
          // Banner
          SizedBox(
            height: 200,
            child: PageView(
              controller: _pageController,
              children: const [
                BannerItem(
                    image:
                        'https://cdn.pixabay.com/photo/2018/04/25/09/26/eiffel-tower-3349075_1280.jpg',
                    title: 'Paris'),
                BannerItem(
                    image:
                        'https://cdn.pixabay.com/photo/2015/03/09/18/34/beach-666122_1280.jpg',
                    title: 'Maldivas'),
                BannerItem(
                    image:
                        'https://cdn.pixabay.com/photo/2014/02/22/14/16/rio-de-janeiro-272052_1280.jpg',
                    title: 'Rio de Janeiro'),
              ],
            ),
          ),
          const SizedBox(height: 20),

          // Barra de Pesquisa
          PrivateSearchBar(
            onSearch: _filterPackages,
          ),
          const SizedBox(height: 20),
          // Lista de pacotes
          PackageList(filteredPackages: filteredPackages),

          const SizedBox(height: 20),

          // Seção de Imagem Local
          const ImageSection(),

          // Seção de Título
          const TitleSection(),

          // Seção de Botões
          const ButtonSection(),

          // Seção de Texto
          const TextSection(),
        ],
      ),
      bottomNavigationBar: const BottomNavBar(),
    );
  }
}
