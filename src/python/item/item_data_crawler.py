import urllib.request


def main():
    response = urllib.request.urlopen(f'https://api.entropianexus.com/items/')
    file = open(f'../../../data/item/Material.20251212070459.csv', 'w')
    file.write(response.read().decode("utf-8"))
    file.close()


if __name__ == "__main__":
    main()
